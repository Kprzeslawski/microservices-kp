package com.przeslawskik.battle_module.service;

import com.przeslawskik.battle_module.mapper.BattleResponse;
import com.przeslawskik.battle_module.mapper.EntityStatsRequest;
import com.przeslawskik.battle_module.mapper.TurnSequence;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

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

        List<TurnSequence> fight_log = new ArrayList<>();
        boolean playerWonFight = false;

        int turn_count = 0;

        while (true){
            double sec_fpt = (100.-playerTurnMeter)/playerStats.getAgile();
            double sec_fet = (100.-enemyTurnMeter)/entityStats.getAgile();
            boolean pTurn = sec_fpt <  sec_fet;

            if(pTurn){
                playerTurnMeter = 0.;
                enemyTurnMeter += sec_fpt * entityStats.getAgile();

                enemyyHp -= 1.;//TODO damage

                if(enemyyHp <= 0){
                    playerWonFight = true;
                    break;
                }

            }else {
                enemyTurnMeter = 0.;
                playerTurnMeter += sec_fet * playerStats.getAgile();

                playerHp -= 1;// TODO 2

                if(playerHp <= 0){
                    playerWonFight = false;
                    break;
                }
            }

            turn_count ++;
        }

        return BattleResponse
                .builder()
                .turnSequenceList(fight_log)
                .itemRewardList(new ArrayList<>())
                .exp_reward(0)
                .gold_reward(0)
                .won(playerWonFight)
                .build();
    }
}
