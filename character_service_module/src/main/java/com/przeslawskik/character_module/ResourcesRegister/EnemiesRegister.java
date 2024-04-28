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
    public static final Map<String,EnemyEntity> register = new HashMap<>(){{
        put(ZOMBIE.getName(),ZOMBIE);
    }};


}
