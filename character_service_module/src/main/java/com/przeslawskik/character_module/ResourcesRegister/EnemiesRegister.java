package com.przeslawskik.character_module.ResourcesRegister;

import com.przeslawskik.character_module.ResourcesRegister.entities.EnemyEntity;

import java.util.ArrayList;

public class EnemiesRegister {

    public static final EnemyEntity ZOMBIE = new EnemyEntity("zombie",
            1,1,1,1,1,1,1,1,1,1,
            new ArrayList<>(){{
                new EnemyEntity.LootTableElem(ItemsRegister.WOODEN_SWORD,0.2);
            }});


}
