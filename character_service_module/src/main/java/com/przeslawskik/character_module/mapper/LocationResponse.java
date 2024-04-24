package com.przeslawskik.character_module.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocationResponse {
    String name;
    Integer min_lv;
}
