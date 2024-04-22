package com.przeslawskik.character_module.repository;

import com.przeslawskik.character_module.documents.PlayerInventory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerInventoryRepository extends MongoRepository<PlayerInventory, ObjectId> {
}
