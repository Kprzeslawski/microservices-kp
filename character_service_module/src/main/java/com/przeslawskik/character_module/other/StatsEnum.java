package com.przeslawskik.character_module.other;

import java.util.Arrays;

public enum StatsEnum {

    HEALTH("health"),
    ATTACK_DAMAGE("attack_dmg"),
    ARMOR("armor"),
    DEFENCE("def"),
    POWER("pow"),
    AGILITY("agile"),
    C_RATE("c_rate"),
    C_DMG("c_dmg");
    private final String asString;

    StatsEnum(String asString){
        this.asString = asString;
    }
    @Override
    public String toString() {
        return asString;
    }

    public static StatsEnum valueOfE(String s){
        return Arrays.stream(StatsEnum.values()).filter(statsEnum -> statsEnum.asString.equals(s)).findFirst().orElseThrow();
    }

}
