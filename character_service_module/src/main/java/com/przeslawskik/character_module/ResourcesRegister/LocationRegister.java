package com.przeslawskik.character_module.ResourcesRegister;

import com.przeslawskik.character_module.ResourcesRegister.entities.LocationEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocationRegister {
    public static final LocationEntity FOREST =
            new LocationEntity("forest", 1, new ArrayList<>(){{
                add(EnemiesRegister.ZOMBIE);
                add(EnemiesRegister.SKELETON);
                add(EnemiesRegister.SPIDER);
            }});

    public static final LocationEntity GRAVEYARD =
            new LocationEntity("graveyard", 2, new ArrayList<>(){{
                add(EnemiesRegister.ZOMBIE);
                add(EnemiesRegister.SKELETON);
                add(EnemiesRegister.GHOST);
            }});




    public static final Map<String, LocationEntity> register = new HashMap<>(){{
        put(FOREST.getName(),FOREST);
        put(GRAVEYARD.getName(),GRAVEYARD);
    }};

}
