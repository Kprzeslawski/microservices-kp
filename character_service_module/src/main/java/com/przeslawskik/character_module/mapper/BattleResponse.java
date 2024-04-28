package com.przeslawskik.character_module.mapper;

import com.przeslawskik.character_module.documents.Item;
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
    List<ItemResponse> receivedItems;
}
