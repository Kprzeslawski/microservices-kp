package com.przeslawskik.character_module.controller;

import com.przeslawskik.character_module.mapper.HeroStatsResponse;
import com.przeslawskik.character_module.service.CSService;
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

    @GetMapping("/champ_stats/{id}")
    public ResponseEntity<HeroStatsResponse> getChampStats(
            @PathVariable Integer id
    ){
        return ResponseEntity.ok(service.getChampStats(id));
    }



}
