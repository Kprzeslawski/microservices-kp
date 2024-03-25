package com.przeslawskik.character_module.other;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Builder
@AllArgsConstructor
@Data
public class BaseItem {
    private final String name;
    private final SlotEnum slot;
    private final Map<StatsEnum,?> avg_stats;

}
