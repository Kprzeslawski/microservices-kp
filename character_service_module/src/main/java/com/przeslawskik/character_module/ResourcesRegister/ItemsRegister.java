package com.przeslawskik.character_module.ResourcesRegister;

import com.przeslawskik.character_module.other.BaseItem;
import com.przeslawskik.character_module.other.SlotEnum;
import com.przeslawskik.character_module.other.StatsEnum;

import java.util.HashMap;

public class ItemsRegister {
    public static final BaseItem WOODEN_SWORD =
            new BaseItem("wooden sword", SlotEnum.HAND,new HashMap<>(){{
                put(StatsEnum.ATTACK_DAMAGE,1);
                put(StatsEnum.ARMOR,1);
            }});
}
