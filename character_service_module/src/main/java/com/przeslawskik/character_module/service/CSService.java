package com.przeslawskik.character_module.service;

import com.przeslawskik.character_module.ResourcesRegister.EnemiesRegister;
import com.przeslawskik.character_module.ResourcesRegister.LocationRegister;
import com.przeslawskik.character_module.ResourcesRegister.entities.EnemyEntity;
import com.przeslawskik.character_module.documents.Hero;
import com.przeslawskik.character_module.documents.Item;
import com.przeslawskik.character_module.documents.PlayerInventory;
import com.przeslawskik.character_module.mapper.*;
import com.przeslawskik.character_module.other.ItemsManipulationHandler;
import com.przeslawskik.character_module.other.Stats;
import com.przeslawskik.character_module.other.StatsEnum;
import com.przeslawskik.character_module.other.helperFunctions;
import com.przeslawskik.character_module.repository.HeroRepository;
import com.przeslawskik.character_module.repository.PlayerInventoryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
                .equipped(
                        h.getEquipped()
                        .stream()
                        .map(item -> new ItemResponse(item.getId().toString(),item.getName(),item.getSlot(),item.getStats()))
                        .toList()
                )
                .build();

    }

    public String createNewHero(HeroCreationRequest request) {
        var creation = Hero.builder()
                .name(request.getName())
                .level(1)
                .exp(0)
                .ownerInv(new ObjectId(request.getPlayerId()))
                .equipped(
                        new ArrayList<>()
                )
                .base_stats(
                        Stats.builder().health(30).attack_dmg(3).build()
                )
                .stats(
                        Stats.builder().health(30).attack_dmg(3).build()
                )
                .build();
        var saved = heroRepository.save(creation);
        return saved.getId().toHexString();
    }

    public EnemyResponse getEnemyStats(String name){
        var entity = EnemiesRegister.register.get(name);

        if(entity == null) throw new RuntimeException("No Enemy With Given Name");

        return new EnemyResponse(
                entity.getName(), entity.getMin_gold(), entity.getMax_gold(), 1,1,entity.getStats());
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

                boolean isCritical =  Math.random() < ((double) hero.getStats().getC_rate() / 100.);
                if(isCritical) damage *= (150. + hero.getStats().getC_dmg()) / 100.;

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

                boolean isCritical =  Math.random() < ((double) enemy.getStats().getC_rate() / 100.);
                if(isCritical) damage *= (150. + enemy.getStats().getC_dmg()) / 100.;

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


        List<Item> lootedItems = new ArrayList<>();
        int newLevels = 0;

        if(playerWonFight){
            rec_gold = helperFunctions.getRandomNumber(enemy.getMin_gold(),enemy.getMax_gold());
            playerInventoryRepository.findAndIncrementGoldById(new ObjectId(pId),rec_gold);

             lootedItems = enemy
                    .getLootTable()
                    .stream()
                    .filter(EnemyEntity.LootTableElem::roll)
                    .map(lootTableElem -> ItemsManipulationHandler.createNewItemBasedOnRegister(lootTableElem.getItem()))
                    .toList();
            if(!lootedItems.isEmpty())playerInventoryRepository.findAndAddItemsById(new ObjectId(pId), lootedItems);

            if(hero.getLevel() != 60){
                rec_exp = helperFunctions.getRandomNumber(enemy.getMin_exp(),enemy.getMax_exp());
                hero.setExp(hero.getExp() + rec_exp);
                while (hero.getExp() >= hero.getLevel() * 20 && hero.getLevel() != 60){
                    hero.setExp(hero.getExp() - hero.getLevel() * 20);
                    newLevels++;
                    hero.setLevel(hero.getLevel()+1);
                }
                if(newLevels > 0){
                    Stats base_st = hero.getBase_stats();
                    Stats st = hero.getStats();

                    base_st.setHealth(base_st.getHealth() + newLevels * 5);
                    st.setHealth(st.getHealth() + newLevels * 5);
                    base_st.setAttack_dmg(base_st.getAttack_dmg() + newLevels);
                    st.setAttack_dmg(st.getAttack_dmg() + newLevels);
                }
                heroRepository.save(hero);
            };
        }

        return BattleResponse
                .builder()
                .playerWon(playerWonFight)
                .fightSequence(fight_log)
                .facedEnemy(enemy.getName())
                .receivedGold(rec_gold)
                .receivedExp(rec_exp)
                .receivedItems(lootedItems
                        .stream()
                        .map(item -> new ItemResponse(item.getId().toString(),item.getName(),item.getSlot(),item.getStats()))
                        .toList()
                )
                .playerLevelUp(newLevels != 0)
                .build();
    }


    public InventoryResponse getPlayerInventory(String playerId) {

        PlayerInventory pi = playerInventoryRepository.findById(new ObjectId(playerId)).orElseThrow(
                () -> new RuntimeException("NO PLAYER WITH GIVEN ID")
        );

        return  InventoryResponse
                .builder()
                .gold(pi.getGold())
                .items(pi
                        .getItems()
                        .stream()
                        .map(item -> new ItemResponse(item.getId().toString(),item.getName(),item.getSlot(),item.getStats()))
                        .toList()
                )
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

    public Boolean changeHeroEquipment(String playerId, String heroId, String itemId) {
        //1. get item and hero
        var hero = heroRepository.findById(new ObjectId(heroId)).orElseThrow(
                () -> new RuntimeException("No Hero With Given ID")
        );
        if(!hero.getOwnerInv().toHexString().equals(playerId))throw new RuntimeException("Not Owner Of That Hero");
        var playerInventory = playerInventoryRepository.findById(new ObjectId(playerId)).orElseThrow(
                () -> new RuntimeException("No Player Inventory With Given ID")
        );
        var search = playerInventory.getItems().stream().filter(item -> item.getId().toHexString().equals(itemId)).findFirst();
        if(search.isEmpty())throw new RuntimeException("No Item With Given ID Present");
        Item itemToEquip = search.get();
        playerInventory.setItems(playerInventory.getItems().stream().filter(item -> item != itemToEquip).toList());
        //remove that item from inv
        var searchInEquipped = hero.getEquipped().stream().filter(item -> item.getSlot().equals(itemToEquip.getSlot())).findFirst();
        boolean alreadyEquippedSTH = searchInEquipped.isPresent();
        if(alreadyEquippedSTH){
            Item curEquipped = searchInEquipped.get();
            hero.setEquipped(hero.getEquipped().stream().filter(item -> item != curEquipped).toList());
            //remove item from player
            var inventoryItems = playerInventory.getItems();
            inventoryItems.add(curEquipped);
            playerInventory.setItems(inventoryItems);
        }

        var equippedItems = hero.getEquipped();
        equippedItems.add(itemToEquip);
        hero.setEquipped(equippedItems);

        //3. calc new stats
        calcHeroNewStats(hero);
        //4. save changes to db
        playerInventoryRepository.save(playerInventory);
        heroRepository.save(hero);

        return true;
    }

    public void calcHeroNewStats(Hero h){
        Stats new_stats = h.getBase_stats();
        for(Item ci : h.getEquipped()){
            Map<String, Integer> item_stats = ci.getStats();
            //can move to mapper for stats - convert map to stats object and handle stats object adding
            if(item_stats.containsKey(StatsEnum.HEALTH.toString())) new_stats.setHealth(new_stats.getHealth() + item_stats.get(StatsEnum.HEALTH.toString()));
            if(item_stats.containsKey(StatsEnum.ATTACK_DAMAGE.toString())) new_stats.setAttack_dmg(new_stats.getAttack_dmg() + item_stats.get(StatsEnum.ATTACK_DAMAGE.toString()));
            if(item_stats.containsKey(StatsEnum.DEFENCE.toString())) new_stats.setDef(new_stats.getDef() + item_stats.get(StatsEnum.DEFENCE.toString()));
            if(item_stats.containsKey(StatsEnum.POWER.toString())) new_stats.setPow(new_stats.getPow() + item_stats.get(StatsEnum.POWER.toString()));
            if(item_stats.containsKey(StatsEnum.ARMOR.toString())) new_stats.setArmor(new_stats.getArmor() + item_stats.get(StatsEnum.ARMOR.toString()));
            if(item_stats.containsKey(StatsEnum.AGILITY.toString())) new_stats.setAgile(new_stats.getAgile() + item_stats.get(StatsEnum.AGILITY.toString()));
            if(item_stats.containsKey(StatsEnum.C_RATE.toString())) new_stats.setC_rate(new_stats.getC_rate() + item_stats.get(StatsEnum.C_RATE.toString()));
            if(item_stats.containsKey(StatsEnum.C_DMG.toString())) new_stats.setC_dmg(new_stats.getC_dmg() + item_stats.get(StatsEnum.C_DMG.toString()));
        }
    }
}
