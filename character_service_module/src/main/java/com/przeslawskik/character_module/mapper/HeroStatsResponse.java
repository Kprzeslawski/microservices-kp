package com.przeslawskik.character_module.mapper;

import com.przeslawskik.character_module.other.Stats;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HeroStatsResponse {
 Stats stats;
}
