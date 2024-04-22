package com.przeslawskik.character_module.documents;

import com.przeslawskik.character_module.other.StatsEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "heroes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hero {

    @Id
    private ObjectId id;
    @Reference
    private ObjectId ownerInv;
    private String name;
    private Integer level;
    private Integer exp;
    private Map<StatsEnum,Integer> base_stats;
    private Map<StatsEnum,Integer> stats;
    private List<Item> equipped;

}
