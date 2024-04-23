package com.przeslawskik.character_module.ResourcesRegister.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class LocationEntity {
    String name;
    Integer min_lv;
    List<EnemyEntity> enemies;
}
