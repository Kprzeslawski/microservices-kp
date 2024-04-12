package com.przeslawskik.character_module.controller;

import com.przeslawskik.character_module.mapper.HeroStatsResponse;
import com.przeslawskik.character_module.service.CSService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hero")
public class CSController {

    @Autowired
    private CSService service;
    @GetMapping("/test")
    public ResponseEntity<Integer> test(){
        return ResponseEntity.ok(service.test_save());
    }

    @GetMapping("/hero_stats/{id}")
    public ResponseEntity<HeroStatsResponse> getChampStats(
            @PathVariable Integer id
    ){
        return ResponseEntity.ok(service.getChampStats(id));
    }
    @GetMapping("/hero_creation")
    public ResponseEntity<ObjectId> createNewHero(){
        return ResponseEntity.ok(service.createNewHero());
    }

    @GetMapping("/award_hero_with_item/{id}")
    public ResponseEntity<Boolean> addItemToInventory(){
        return ResponseEntity.ok(service.addItemToInventory());
    }

    @GetMapping("/award_hero_with_xp/")
    public ResponseEntity<Boolean> awardWithXp(){
        return ResponseEntity.ok(service.awardWithXp());
    }

    @GetMapping("/change_hero_equipment")
    public ResponseEntity<Boolean> changeEquipment(){
        return ResponseEntity.ok(service.changeEquipment());
    }

    @GetMapping("/hero_inventory")
    public ResponseEntity<Boolean> getHeroInventory(){
        return ResponseEntity.ok(service.getHeroInventory());
    }

}
