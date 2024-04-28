package com.przeslawskik.character_module.repository;

import com.przeslawskik.character_module.documents.Item;
import com.przeslawskik.character_module.documents.PlayerInventory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerInventoryRepository extends MongoRepository<PlayerInventory, ObjectId> {

    @Update("{ '$inc' : { 'gold' : ?1 } }")
    void findAndIncrementGoldById(ObjectId id, int increment);

    @Update("{ $push: { items: { $each: ?1 } } }")
    void findAndAddItemsById(ObjectId objectId, List<Item> i);
}
