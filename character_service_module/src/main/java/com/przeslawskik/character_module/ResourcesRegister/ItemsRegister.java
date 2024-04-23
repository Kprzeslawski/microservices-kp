package com.przeslawskik.character_module.ResourcesRegister;

import com.przeslawskik.character_module.ResourcesRegister.entities.ItemEntity;
import com.przeslawskik.character_module.other.SlotEnum;
import com.przeslawskik.character_module.other.StatsEnum;

import java.util.HashMap;

public class ItemsRegister {
    public static final ItemEntity WOODEN_SWORD =
            new ItemEntity("wooden sword", SlotEnum.HAND ,new HashMap<>(){{
                put(StatsEnum.ATTACK_DAMAGE,1);put(StatsEnum.ARMOR,1);
            }});
    public static final ItemEntity STONE_SWORD =
            new ItemEntity("stone sword", SlotEnum.HAND ,new HashMap<>(){{
                put(StatsEnum.ATTACK_DAMAGE,2);put(StatsEnum.ARMOR,1);
            }});
    public static final ItemEntity IRON_SWORD =
            new ItemEntity("iron sword", SlotEnum.HAND ,new HashMap<>(){{
                put(StatsEnum.ATTACK_DAMAGE,3);put(StatsEnum.ARMOR,2);
            }});
}
