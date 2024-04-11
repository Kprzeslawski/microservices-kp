package com.przeslawskik.character_module.other;

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
}
