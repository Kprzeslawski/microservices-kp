package com.przeslawskik.character_module.repository;

import com.przeslawskik.character_module.documents.PlayerInventory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerInventoryRepository extends MongoRepository<PlayerInventory, ObjectId> {

}
