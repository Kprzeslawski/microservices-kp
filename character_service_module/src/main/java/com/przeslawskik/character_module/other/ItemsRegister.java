package com.przeslawskik.character_module.other;

import java.util.HashMap;

public class ItemsRegister {
    public static final BaseItem WOODEN_SWORD =
            new BaseItem("wooden sword",SlotEnum.HAND,new HashMap<>(){{
                put(StatsEnum.ATTACK_DAMAGE,1);
                put(StatsEnum.ARMOR,1);
            }});




}
