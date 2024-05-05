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


    public static final EnemyEntity SKELETON = new EnemyEntity("skeleton",
            Stats.builder().health(25).attack_dmg(3).build(),3,5, 3, 5,
            new ArrayList<>(){{
                add(new EnemyEntity.LootTableElem(ItemsRegister.STONE_SWORD,0.05));
            }});

    public static final EnemyEntity SPIDER = new EnemyEntity("spider",
            Stats.builder().health(15).attack_dmg(5).build(),1,2, 5, 8,
            new ArrayList<>(){{
                add(new EnemyEntity.LootTableElem(ItemsRegister.LEATHER_HELMET,0.1));
                add(new EnemyEntity.LootTableElem(ItemsRegister.LEATHER_LEGGINGS,0.1));
                add(new EnemyEntity.LootTableElem(ItemsRegister.LEATHER_CHESTPLATE,0.1));
                add(new EnemyEntity.LootTableElem(ItemsRegister.LEATHER_BOOTS,0.1));
            }});

    public static final EnemyEntity GHOST = new EnemyEntity("ghost",
            Stats.builder().health(40).attack_dmg(4).build(),3,5, 10, 12, new ArrayList<>());

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
        put(SKELETON.getName(),SKELETON);
        put(SPIDER.getName(),SPIDER);
        put(GHOST.getName(),GHOST);
        put(GUARDIAN.getName(),GUARDIAN);
    }};


}
