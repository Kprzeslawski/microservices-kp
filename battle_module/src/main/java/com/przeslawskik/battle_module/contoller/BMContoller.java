package com.przeslawskik.battle_module.contoller;

import com.przeslawskik.battle_module.service.BMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/battle")
public class BMContoller {
    @Autowired
    private BMService service;

    @GetMapping("/battle_result/{pId}/{mobId}")
    public ResponseEntity<Long> getBattleResult(
            @PathVariable Integer pId,
            @PathVariable Integer mobId
    ){
        return ResponseEntity.ok(service.getBattleResult(pId,mobId));
    }
}
