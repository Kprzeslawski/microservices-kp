package com.przeslawskik.character_module.documents;

import com.przeslawskik.character_module.other.SlotEnum;
import com.przeslawskik.character_module.other.StatsEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @Id
    @Builder.Default
    private ObjectId id = new ObjectId();
    private String name;
    private String slot;
    private Map<String,Integer> stats;
}
