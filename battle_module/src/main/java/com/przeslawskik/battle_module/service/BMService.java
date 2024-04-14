package com.przeslawskik.battle_module.service;

import com.przeslawskik.battle_module.mapper.BattleResponse;
import com.przeslawskik.battle_module.mapper.EntityStatsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class BMService {
    @Autowired
    private WebClient webClient;
    public BattleResponse getBattleResult(Integer pId, Integer mobId) {
        EntityStatsRequest playerStats = webClient.get()
                .uri("http://character_service_module/...")
                .retrieve()
                .bodyToMono(EntityStatsRequest.class)
                .block();

        EntityStatsRequest entityStats = webClient.get()
                .uri("http://character_service_module/...")
                .retrieve()
                .bodyToMono(EntityStatsRequest.class)
                .block();

        assert playerStats != null;
        assert entityStats != null;

        double playerTurnMeter = 0.;
        double enemyTurnMeter = 0.;

        int playerHp = playerStats.getHealth();
        int enemyyHp = entityStats.getHealth();


        return null;
    }
}
