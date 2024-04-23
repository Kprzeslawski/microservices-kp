package com.przeslawskik.character_module.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "inventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerInventory {
    @Id
    private ObjectId id;
    private Integer gold;
    private List<Item> items;

}
