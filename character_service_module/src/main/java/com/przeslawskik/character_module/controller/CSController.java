package com.przeslawskik.character_module.controller;

import com.przeslawskik.character_module.mapper.*;
import com.przeslawskik.character_module.service.CSService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/hero-stats/{playerId}/{heroId}")
    public ResponseEntity<HeroStatsResponse> getChampStats(
            @PathVariable String playerId,
            @PathVariable String heroId
    ){
        return ResponseEntity.ok(service.getChampStats(playerId,heroId));
    }

    @PostMapping("/hero_creation")
    public ResponseEntity<String> createNewHero(
            @RequestBody HeroCreationRequest request
    ){
        return ResponseEntity.ok(service.createNewHero(request));
    }

    @GetMapping("/player_inventory/{playerId}")
    public ResponseEntity<?> getHeroInventory(
            @PathVariable String playerId
    ){
        try{
            return ResponseEntity.ok(service.getPlayerInventory(playerId));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/new_player_account")
    public ResponseEntity<String> createNewPlayerAccount(){
        return ResponseEntity.ok(service.createNewPlayerAccount());
    }

    @GetMapping("/enemy_stat/{name}")
    public ResponseEntity<?> getEnemyStat(
            @PathVariable String name
    ){
        try{
            return ResponseEntity.ok(service.getEnemyStats(name));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/location_enemies/{locId}")
    public ResponseEntity<?> getLocationEnemies(
            @PathVariable String locName
    ){
        try{
            return ResponseEntity.ok(service.getLocationEnemies(locName));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/location_fight/{playerId}/{heroId}/{locName}")
    public ResponseEntity<?> getLocationFight(
            @PathVariable String playerId,
            @PathVariable String heroId,
            @PathVariable String locName
    ){
        try{
            return ResponseEntity.ok(service.getLocationFight(playerId, heroId, locName));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/locations")
    public ResponseEntity<List<LocationResponse>> getLocations(){
        return ResponseEntity.ok(service.getLocations());
    }
}
