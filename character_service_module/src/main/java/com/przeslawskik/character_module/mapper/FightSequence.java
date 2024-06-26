package com.przeslawskik.character_module.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FightSequence {
    boolean playerDealtDamage;
    boolean isCritical;
    int entityDamageDealt;
    int secondEntityHpLeft;
}
