package com.przeslawskik.character_module.other;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Stats {
    Integer health = 0;
    Integer attack_dmg = 0;
    Integer armor = 0;
    Integer def = 0;
    Integer pow = 0;
    Integer agile = 0;
    Integer c_rate = 0;
    Integer c_dmg = 0;
}
