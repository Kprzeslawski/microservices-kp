package com.przeslawskik.battle_module.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BattleResponse {
    List<TurnSequence> turnSequenceList;
    Integer gold_reward;
    Integer exp_reward;
    Boolean won;
    List<ItemReward> itemRewardList;
}
