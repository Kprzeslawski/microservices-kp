package com.przeslawskik.character_module.ResourcesRegister;

import com.przeslawskik.character_module.ResourcesRegister.entities.EnemyEntity;
import com.przeslawskik.character_module.other.Stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EnemiesRegister {
    public static final EnemyEntity ZOMBIE = new EnemyEntity("zombie",
            Stats.builder().health(20).attack_dmg(2).build(),1,1, 1, 1,
            new ArrayList<>(){{
                add(new EnemyEntity.LootTableElem(ItemsRegister.WOODEN_SWORD,1.));
            }});

    public static final EnemyEntity GUARDIAN = new EnemyEntity("guardian",
            Stats.builder().health(60).attack_dmg(5).armor(3).build(),10,12, 15, 20,
            new ArrayList<>(){{
                add(new EnemyEntity.LootTableElem(ItemsRegister.IRON_SWORD,0.1));
                add(new EnemyEntity.LootTableElem(ItemsRegister.IRON_HELMET,0.1));
                add(new EnemyEntity.LootTableElem(ItemsRegister.IRON_CHESTPLATE,0.1));
                add(new EnemyEntity.LootTableElem(ItemsRegister.IRON_LEGGINGS,0.1));
                add(new EnemyEntity.LootTableElem(ItemsRegister.IRON_BOOTS,0.1));
            }});




    public static final Map<String,EnemyEntity> register = new HashMap<>(){{
        put(ZOMBIE.getName(),ZOMBIE);
        put(GUARDIAN.getName(),GUARDIAN);
    }};


}
