package com.przeslawskik.character_module.documents;

import com.przeslawskik.character_module.other.Stats;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "heroes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hero {

    @Id
    private ObjectId id;

    private ObjectId ownerInv;
    private String name;
    private Integer level;
    private Integer exp;
    private Stats base_stats;
    private Stats stats;
    private List<Item> equipped;

}
