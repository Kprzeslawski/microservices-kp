package com.przeslawskik.character_service_module.documents;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "items")
@Data
public class Item {
    @Id
    private ObjectId id;
}
