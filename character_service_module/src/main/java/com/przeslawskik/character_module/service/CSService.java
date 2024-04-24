package com.przeslawskik.character_module.service;

import com.przeslawskik.character_module.ResourcesRegister.EnemiesRegister;
import com.przeslawskik.character_module.ResourcesRegister.LocationRegister;
import com.przeslawskik.character_module.documents.Hero;
import com.przeslawskik.character_module.documents.PlayerInventory;
import com.przeslawskik.character_module.mapper.*;
import com.przeslawskik.character_module.other.Stats;
import com.przeslawskik.character_module.repository.HeroRepository;
import com.przeslawskik.character_module.repository.PlayerInventoryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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




        return null;
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
