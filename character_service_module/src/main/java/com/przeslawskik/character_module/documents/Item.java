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
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Map;

@Document(collection = "items_entities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @Id
    private ObjectId id;

    @DocumentReference
    private Hero hero;



    private Map<StatsEnum,?> stats;

}
