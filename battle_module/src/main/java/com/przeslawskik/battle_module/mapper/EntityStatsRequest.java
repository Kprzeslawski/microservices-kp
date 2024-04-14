package com.przeslawskik.battle_module.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class EntityStatsRequest {
    Integer health;
    Integer attack_dmg;
    Integer armor;
    Integer def;
    Integer pow;
    Integer agile;
    Integer c_rate;
    Integer c_dmg;

}
