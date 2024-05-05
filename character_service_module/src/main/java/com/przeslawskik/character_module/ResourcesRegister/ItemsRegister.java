package com.przeslawskik.character_module.ResourcesRegister;

import com.przeslawskik.character_module.ResourcesRegister.entities.ItemEntity;
import com.przeslawskik.character_module.other.SlotEnum;
import com.przeslawskik.character_module.other.StatsEnum;

import java.util.HashMap;
import java.util.Map;

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

    public static final ItemEntity LEATHER_BOOTS =
            new ItemEntity("leather boots", SlotEnum.BOOTS ,new HashMap<>(){{
                put(StatsEnum.HEALTH,4);put(StatsEnum.ARMOR,2);
            }});

    public static final ItemEntity LEATHER_CHESTPLATE =
            new ItemEntity("leather chestplate", SlotEnum.CHEST ,new HashMap<>(){{
                put(StatsEnum.HEALTH,4);put(StatsEnum.ARMOR,2);
            }});

    public static final ItemEntity LEATHER_LEGGINGS =
            new ItemEntity("leather leggings", SlotEnum.LEGGINGS ,new HashMap<>(){{
                put(StatsEnum.HEALTH,4);put(StatsEnum.ARMOR,2);
            }});

    public static final ItemEntity LEATHER_HELMET =
            new ItemEntity("leather helmet", SlotEnum.HELMET ,new HashMap<>(){{
                put(StatsEnum.HEALTH,4);put(StatsEnum.ARMOR,2);
            }});

    public static final ItemEntity IRON_BOOTS =
            new ItemEntity("iron boots", SlotEnum.BOOTS ,new HashMap<>(){{
                put(StatsEnum.HEALTH,6);put(StatsEnum.ARMOR,2);put(StatsEnum.DEFENCE,2);
            }});

    public static final ItemEntity IRON_CHESTPLATE =
            new ItemEntity("iron chestplate", SlotEnum.CHEST ,new HashMap<>(){{
                put(StatsEnum.HEALTH,6);put(StatsEnum.ARMOR,2);put(StatsEnum.DEFENCE,2);
            }});

    public static final ItemEntity IRON_LEGGINGS =
            new ItemEntity("iron leggings", SlotEnum.LEGGINGS ,new HashMap<>(){{
                put(StatsEnum.HEALTH,6);put(StatsEnum.ARMOR,2);put(StatsEnum.DEFENCE,2);
            }});

    public static final ItemEntity IRON_HELMET =
            new ItemEntity("iron helmet", SlotEnum.HELMET ,new HashMap<>(){{
                put(StatsEnum.HEALTH,6);put(StatsEnum.ARMOR,2);put(StatsEnum.DEFENCE,2);
            }});

    public static final Map<String, ItemEntity> register = new HashMap<>(){{
        put(WOODEN_SWORD.getName(),WOODEN_SWORD);
        put(STONE_SWORD.getName(),STONE_SWORD);
        put(IRON_SWORD.getName(),IRON_SWORD);

        put(LEATHER_BOOTS.getName(),LEATHER_BOOTS);
        put(LEATHER_CHESTPLATE.getName(),LEATHER_CHESTPLATE);
        put(LEATHER_LEGGINGS.getName(),LEATHER_LEGGINGS);
        put(LEATHER_HELMET.getName(),LEATHER_HELMET);

        put(IRON_BOOTS.getName(),IRON_BOOTS);
        put(IRON_CHESTPLATE.getName(),IRON_CHESTPLATE);
        put(IRON_LEGGINGS.getName(),IRON_LEGGINGS);
        put(IRON_HELMET.getName(),IRON_HELMET);
    }};

}
