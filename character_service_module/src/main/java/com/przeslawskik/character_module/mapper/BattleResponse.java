package com.przeslawskik.character_module.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class BattleResponse {
    boolean playerWon;
    List<FightSequence> fightSequence;
    int receivedGold;
    int receivedExp;
    boolean playerLevelUp;
    //TODO recived items
}
