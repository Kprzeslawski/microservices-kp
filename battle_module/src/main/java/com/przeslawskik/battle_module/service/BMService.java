package com.przeslawskik.battle_module.service;

import com.przeslawskik.battle_module.mapper.BattleResponse;
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


        return null;
    }
}
