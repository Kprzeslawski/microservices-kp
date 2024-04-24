package com.przeslawskik.character_module.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

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
