package com.przeslawskik.character_module.ResourcesRegister;

import com.przeslawskik.character_module.ResourcesRegister.entities.ItemEntity;
import com.przeslawskik.character_module.ResourcesRegister.entities.LocationEntity;

import java.util.ArrayList;
import java.util.List;

public class LocationRegister {
    public static final LocationEntity FOREST =
            new LocationEntity("forest", 1, new ArrayList<>(){{
                add(EnemiesRegister.ZOMBIE);
            }});
}
