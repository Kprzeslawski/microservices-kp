package com.przeslawskik.character_module.mapper;

import com.przeslawskik.character_module.other.Stats;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnemyResponse {
    String name;
    Integer min_gold;
    Integer max_gold;
    Integer min_exp;
    Integer max_exp;
    Stats stats;
}
