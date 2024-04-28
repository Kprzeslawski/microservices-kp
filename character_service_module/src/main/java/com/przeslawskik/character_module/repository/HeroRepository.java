package com.przeslawskik.character_module.repository;

import com.przeslawskik.character_module.documents.Hero;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends MongoRepository<Hero, ObjectId> {

    @Update("{ '$inc' : { 'exp' : ?1 } }")
    void findAndIncrementExpById(ObjectId objectId, int recExp);

    @Update("{ '$set' : { 'exp' : ?1, 'level' : ?2 } }")
    void findAndSetHeroExpAndLevelById(ObjectId objectId, Integer exp, Integer level);
}
