package com.przeslawskik.character_module.service;

import com.przeslawskik.character_module.documents.Hero;
import com.przeslawskik.character_module.documents.PlayerInventory;
import com.przeslawskik.character_module.mapper.*;
import com.przeslawskik.character_module.other.StatsEnum;
import com.przeslawskik.character_module.repository.HeroRepository;
import com.przeslawskik.character_module.repository.PlayerInventoryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public HeroStatsResponse getChampStats(ObjectId pId) {

        var h = heroRepository.findById(pId);

        if(h.isEmpty())throw new RuntimeException("NO HERO WITH ID");

        return HeroStatsResponse
                .builder()
                    .health(h.get().getStats().get(StatsEnum.HEALTH))
                    .attack_dmg(h.get().getStats().get(StatsEnum.ATTACK_DAMAGE))
                    .armor(h.get().getStats().get(StatsEnum.ARMOR))
                    .def(h.get().getStats().get(StatsEnum.DEFENCE))
                    .pow(h.get().getStats().get(StatsEnum.POWER))
                    .agile(h.get().getStats().get(StatsEnum.AGILITY))
                    .c_rate(h.get().getStats().get(StatsEnum.C_RATE))
                    .c_dmg(h.get().getStats().get(StatsEnum.C_DMG))
                .build();

    }

    public ObjectId createNewHero(HeroCreationRequest request) {
        var h = Hero.builder()
                .name(request.getName())
                .level(1)
                .exp(0)
                .stats(
                        new HashMap<>(){{
                            put(StatsEnum.HEALTH, 20);
                            put(StatsEnum.ATTACK_DAMAGE,2);
                            put(StatsEnum.ARMOR,0);
                            put(StatsEnum.DEFENCE,0);
                            put(StatsEnum.POWER,0);
                            put(StatsEnum.AGILITY,0);
                            put(StatsEnum.C_RATE,0);
                            put(StatsEnum.C_DMG,0);
                        }}
                )
                .build();

        return heroRepository.save(h).getId();
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

    public ObjectId createNewPlayerAccount() {

        PlayerInventory pI = new PlayerInventory();

        return playerInventoryRepository.save(pI).getId();

    }
}
