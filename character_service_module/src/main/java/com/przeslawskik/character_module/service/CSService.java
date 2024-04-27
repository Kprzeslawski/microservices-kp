package com.przeslawskik.character_module.service;

import com.mongodb.client.MongoClient;
import com.przeslawskik.character_module.ResourcesRegister.EnemiesRegister;
import com.przeslawskik.character_module.ResourcesRegister.LocationRegister;
import com.przeslawskik.character_module.ResourcesRegister.entities.EnemyEntity;
import com.przeslawskik.character_module.documents.Hero;
import com.przeslawskik.character_module.documents.PlayerInventory;
import com.przeslawskik.character_module.mapper.*;
import com.przeslawskik.character_module.other.Stats;
import com.przeslawskik.character_module.other.helperFunctions;
import com.przeslawskik.character_module.repository.HeroRepository;
import com.przeslawskik.character_module.repository.PlayerInventoryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CSService {

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private PlayerInventoryRepository playerInventoryRepository;

    public HeroStatsResponse getChampStats(String pId, String hId) {

        var h = heroRepository.findById(new ObjectId(hId)).orElseThrow(
                () -> new RuntimeException("No Hero With Given ID")
        );
        if(!h.getOwnerInv().toHexString().equals(pId))throw new RuntimeException("Not Owner Of That Hero");

        return HeroStatsResponse
                .builder()
                .stats(h.getStats())
                .build();

    }

    public String createNewHero(HeroCreationRequest request) {
        var creation = Hero.builder()
                .name(request.getName())
                .level(1)
                .exp(0)
                .ownerInv(new ObjectId(request.getPlayerId()))
                .stats(
                        Stats.builder().health(20).attack_dmg(2).build()
                )
                .build();
        var saved = heroRepository.save(creation);
        return saved.getId().toHexString();
    }

    public HeroStatsResponse getEnemyStats(String name){
        var entity = EnemiesRegister.register.get(name);

        if(entity == null) throw new RuntimeException("No Enemy With Given Name");

        return new HeroStatsResponse(
                entity.getStats()
        );
    }

    public List<EnemyResponse> getLocationEnemies(String locName) {
        var entity = LocationRegister.register.get(locName);

        if(entity == null) throw new RuntimeException("No Location With Given Name");

        return entity.getEnemies()
                .stream()
                .map(rec -> new EnemyResponse(
                        rec.getName(), rec.getMin_gold(), rec.getMax_gold(), 1,1,rec.getStats()
                ))
                .toList();
    }

    public List<LocationResponse> getLocations() {
        return LocationRegister.register.values()
                .stream()
                .map(rec -> new LocationResponse(
                        rec.getName(),rec.getMin_lv()
                ))
                .toList();
    }

    public BattleResponse getLocationFight(String pId, String hId, String locName) {

        var location = LocationRegister.register.get(locName);
        if(location == null) throw new RuntimeException("No Location With Given Name");

        var hero = heroRepository.findById(new ObjectId(hId)).orElseThrow(
                () -> new RuntimeException("No Hero With Given ID")
        );
        if(!hero.getOwnerInv().toHexString().equals(pId))throw new RuntimeException("Not Owner Of That Hero");

        Random rand = new Random();
        EnemyEntity enemy = location.getEnemies().get(
                rand.nextInt(location.getEnemies().size())
        );

        int enemyHp = enemy.getStats().getHealth();
        int playerHp = hero.getStats().getHealth();
        double playerTurnMeter = 0.;
        double enemyTurnMeter = 0.;

        List<FightSequence> fight_log = new ArrayList<>();
        boolean playerWonFight = false;

        while (playerHp > 0 && enemyHp > 0){
            double sec_fpt = (100.-playerTurnMeter)/(hero.getStats().getAgile() + 100.);
            double sec_fet = (100.-enemyTurnMeter)/(enemy.getStats().getAgile() + 100.);
            boolean pTurn = sec_fpt < sec_fet;

            if(pTurn){
                playerTurnMeter = 0.;
                enemyTurnMeter += sec_fpt * (enemy.getStats().getAgile() + 100.);

                double damage = hero.getStats().getAttack_dmg()
                        * Math.pow(1.01, hero.getStats().getPow())
                        * helperFunctions.getRandomizedDamageMultiplier();
                //TODO check for crit
                int damage_received = (int) Math.round(damage * Math.pow(0.99, enemy.getStats().getDef()))
                        - enemy.getStats().getArmor();
                if(damage_received <= 0)damage_received = 1;

                enemyHp -= damage_received;
                fight_log.add(new FightSequence(true,damage_received,enemyHp));
            }else {
                enemyTurnMeter = 0.;
                playerTurnMeter += sec_fet * (hero.getStats().getAgile() + 100.);

                double damage = enemy.getStats().getAttack_dmg()
                        * Math.pow(1.01, enemy.getStats().getPow())
                        * helperFunctions.getRandomizedDamageMultiplier();
                //TODO check for crit
                int damage_received = (int) Math.round(damage * Math.pow(0.99, hero.getStats().getDef()))
                        - hero.getStats().getArmor();
                if(damage_received <= 0)damage_received = 1;

                playerHp -= damage_received;
                fight_log.add(new FightSequence(false,damage_received,playerHp));
            }

        }

        if(playerHp > 0)
            playerWonFight = true;

        int rec_gold=0;
        int rec_exp=0;



        if(playerWonFight){
            rec_gold = helperFunctions.getRandomNumber(enemy.getMin_gold(),enemy.getMax_gold());
            rec_exp = helperFunctions.getRandomNumber(enemy.getMin_exp(),enemy.getMax_exp());

            playerInventoryRepository.findAndIncrementGoldById(new ObjectId(pId),rec_gold);

            //ReactiveMongoTemplate
            //update gold and exp;
//            playerInventoryRepository.updatePlayerGold();
//            heroRepository.updateHeroExpAndLevel();
            //TODO roll for items and save new values
        }

        return BattleResponse
                .builder()
                .playerWon(playerWonFight)
                .fightSequence(fight_log)
                .receivedGold(rec_gold)
                .receivedExp(rec_exp)
                .build();
    }


    public InventoryResponse getPlayerInventory(String playerId) {

        PlayerInventory pi = playerInventoryRepository.findById(new ObjectId(playerId)).orElseThrow(
                () -> new RuntimeException("NO PLAYER WITH GIVEN ID")
        );

        return  InventoryResponse
                .builder()
                .gold(pi.getGold())
                .items(pi.getItems())
                .build();
    }

    public String createNewPlayerAccount() {
        return playerInventoryRepository
                .save(
                        PlayerInventory
                                .builder()
                                .gold(0)
                                .items(new ArrayList<>())
                                .build()
                )
                .getId()
                .toHexString();
    }
}
