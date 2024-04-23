package com.przeslawskik.character_module.ResourcesRegister.entities;

import com.przeslawskik.character_module.other.Stats;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class EnemyEntity {
    String name;

    Stats stats;

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
