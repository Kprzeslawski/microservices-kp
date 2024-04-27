package com.przeslawskik.character_module.other;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Stats {

    @Builder.Default
    Integer health = 0;

    @Builder.Default
    Integer attack_dmg = 0;

    @Builder.Default
    Integer armor = 0;

    @Builder.Default
    Integer def = 0;

    @Builder.Default
    Integer pow = 0;

    @Builder.Default
    Integer agile = 0;

    @Builder.Default
    Integer c_rate = 0;

    @Builder.Default
    Integer c_dmg = 0;
}
