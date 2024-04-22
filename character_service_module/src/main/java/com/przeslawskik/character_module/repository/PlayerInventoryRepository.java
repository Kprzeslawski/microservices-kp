package com.przeslawskik.character_module.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerInventoryRepository extends MongoRepository<PlayerInventoryRepository, ObjectId> {
}
