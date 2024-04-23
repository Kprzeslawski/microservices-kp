package com.przeslawskik.character_module.service;

import com.przeslawskik.character_module.documents.Hero;
import com.przeslawskik.character_module.documents.PlayerInventory;
import com.przeslawskik.character_module.mapper.*;
import com.przeslawskik.character_module.other.Stats;
import com.przeslawskik.character_module.other.StatsEnum;
import com.przeslawskik.character_module.repository.HeroRepository;
import com.przeslawskik.character_module.repository.PlayerInventoryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CSService {

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private PlayerInventoryRepository playerInventoryRepository;

    public Integer test_save(){

        return 0;
    }

    public HeroStatsResponse getChampStats(String pId, String hId) {

        var h = heroRepository.findById(new ObjectId(hId)).orElseThrow();

        if(!h.getOwnerInv().toHexString().equals(pId))throw new RuntimeException("NOT OWNER OF HERO");

        return HeroStatsResponse
                .builder()
                    .health(h.getStats().getHealth())
                    .attack_dmg(h.getStats().getAttack_dmg())
                    .armor(h.getStats().getArmor())
                    .def(h.getStats().getDef())
                    .pow(h.getStats().getPow())
                    .agile(h.getStats().getAgile())
                    .c_rate(h.getStats().getC_rate())
                    .c_dmg(h.getStats().getC_dmg())
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
//                        new HashMap<>(){{
//                            put(StatsEnum.HEALTH.toString(), 20);
//                            put(StatsEnum.ATTACK_DAMAGE.toString(),2);
//                            put(StatsEnum.ARMOR.toString(),0);
//                            put(StatsEnum.DEFENCE.toString(),0);
//                            put(StatsEnum.POWER.toString(),0);
//                            put(StatsEnum.AGILITY.toString(),0);
//                            put(StatsEnum.C_RATE.toString(),0);
//                            put(StatsEnum.C_DMG.toString(),0);
//                        }}
                )
                .build();
        var saved = heroRepository.save(creation);
        return saved.getId().toHexString();
    }

//    public Boolean addItemToInventory() {
//        return null;
//    }
//
//    public Boolean awardWithXp() {
//        return null;
//    }

    public HeroStatsResponse changeEquipment() {
        return null;
    }

    public Boolean getHeroInventory() {
        return null;
    }

    public HeroStatsResponse getEnemyStats(Integer id) {
        return null;
    }

    public List<EnemyResponse> getLocationEnemies(Integer locId) {
        return null;
    }

    public List<LocationResponse> getLocations() {
        return null;
    }

    public BattleResponse getLocationFight(ObjectId id, Integer locId) {
        return null;
    }



    public InventoryResponse getPlayerInventory(String playerId) {

        PlayerInventory pi = playerInventoryRepository.findById(new ObjectId(playerId)).orElseThrow();
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
