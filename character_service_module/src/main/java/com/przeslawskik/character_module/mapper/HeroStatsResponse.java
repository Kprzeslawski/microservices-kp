package com.przeslawskik.character_module.mapper;

import com.przeslawskik.character_module.other.Stats;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HeroStatsResponse {
 String name;
 Integer level;
 Integer exp;
 Stats stats;
 List<ItemResponse> equipped;
}
