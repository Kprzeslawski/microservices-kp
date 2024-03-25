package com.przeslawskik.character_module.repository;

import com.przeslawskik.character_module.documents.Hero;
import com.przeslawskik.character_module.documents.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, ObjectId> {
}
