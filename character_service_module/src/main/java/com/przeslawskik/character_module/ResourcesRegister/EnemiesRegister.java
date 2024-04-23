package com.przeslawskik.character_module.ResourcesRegister;

import com.przeslawskik.character_module.ResourcesRegister.entities.EnemyEntity;
import com.przeslawskik.character_module.other.Stats;

import java.util.ArrayList;

public class EnemiesRegister {

    public static final EnemyEntity ZOMBIE = new EnemyEntity("zombie",
            Stats.builder().health(20).attack_dmg(2).build(),1,1,
            new ArrayList<>(){{
                new EnemyEntity.LootTableElem(ItemsRegister.WOODEN_SWORD,0.2);
            }});


}
