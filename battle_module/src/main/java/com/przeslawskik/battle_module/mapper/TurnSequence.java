package com.przeslawskik.battle_module.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TurnSequence {

    Double when_occurred;
    Boolean player_dealt; //one for player dealt dmg to mob
    Integer amount;
    Integer player_hp;
    Integer enemy_hp;

}
