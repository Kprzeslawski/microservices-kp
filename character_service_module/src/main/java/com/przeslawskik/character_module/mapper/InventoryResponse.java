package com.przeslawskik.character_module.mapper;

import com.przeslawskik.character_module.documents.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {
    private Integer gold;
    private List<ItemResponse> items;
}
