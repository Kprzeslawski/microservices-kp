package com.przeslawskik.character_module.ResourcesRegister.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class EnemyEntity {
    String name;

    Integer health;
    Integer attack_dmg;
    Integer armor;
    Integer def;
    Integer pow;
    Integer agile;
    Integer c_rate;
    Integer c_dmg;

    Integer min_gold;
    Integer max_gold;

    List<LootTableElem> lootTable;
    @Builder
    @AllArgsConstructor
    @Data
    public static class LootTableElem{
        ItemEntity item;
        Double chance;
    }
}
