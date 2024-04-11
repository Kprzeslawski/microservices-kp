package com.przeslawskik.character_module.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HeroStatsResponse {
 int ok;

 Integer health;
 Integer attack_dmg;
 Integer armor;
 Integer def;
 Integer pow;
 Integer agile;
 Integer c_rate;
 Integer c_dmg;
}
