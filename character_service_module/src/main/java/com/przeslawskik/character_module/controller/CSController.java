package com.przeslawskik.character_module.controller;

import com.przeslawskik.character_module.mapper.*;
import com.przeslawskik.character_module.service.CSService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.EndElement;
import java.util.List;

@RestController
@RequestMapping("/api/player")
public class CSController {

    @Autowired
    private CSService service;

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/hero-stats/{id}")
    public ResponseEntity<HeroStatsResponse> getChampStats(
            @PathVariable ObjectId id
    ){
        return ResponseEntity.ok(service.getChampStats(id));
    }

    @GetMapping("/enemy-stat/{id}")
    public ResponseEntity<HeroStatsResponse> getEnemyStat(
            @PathVariable Integer id
    ){
        return ResponseEntity.ok(service.getEnemyStats(id));
    }
    @GetMapping("/location-enemies/{locId}")
    public ResponseEntity<List<EnemyResponse>> getLocationEnemies(
            @PathVariable Integer locId
    ){
        return ResponseEntity.ok(service.getLocationEnemies(locId));
    }

    @GetMapping("/locations")
    public ResponseEntity<List<LocationResponse>> getLocations(){
        return ResponseEntity.ok(service.getLocations());
    }

    @GetMapping("/location_fight/{playerId}/{heroId}/{locId}")
    public ResponseEntity<BattleResponse> getLocationFight(
            @PathVariable ObjectId id,
            @PathVariable Integer locId
    ){
        return ResponseEntity.ok(service.getLocationFight(id,locId));
    }

    @PostMapping("/hero_creation/{playerId}")
    public ResponseEntity<ObjectId> createNewHero(
            @RequestBody HeroCreationRequest request
    ){
        return ResponseEntity.ok(service.createNewHero(request));
    }

//    @GetMapping("/changeHeroEquipment/{playerId}/{heroId}}")
//    public ResponseEntity<HeroStatsResponse> changeEquipment(
//            @PathVariable ObjectId playerId,
//            @PathVariable Integer heroId
//    ){
//        return ResponseEntity.ok(service.changeEquipment());
//    }

    @GetMapping("/player_inventory/{playerId}")
    public ResponseEntity<InventoryResponse> getHeroInventory(
            @PathVariable String playerId
    ){
        return ResponseEntity.ok(service.getPlayerInventory(playerId));
    }

    @GetMapping("/new_player_account")
    public ResponseEntity<String> createNewPlayerAccount(){
        return ResponseEntity.ok(service.createNewPlayerAccount());
    }

}
