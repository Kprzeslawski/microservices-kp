package com.przeslawskik.character_module.ResourcesRegister.entities;

import com.przeslawskik.character_module.other.SlotEnum;
import com.przeslawskik.character_module.other.StatsEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Builder
@AllArgsConstructor
@Data
public class ItemEntity {

    private final String name;
    private final SlotEnum slot;
    private final Map<StatsEnum,Integer> avg_stats;

}
