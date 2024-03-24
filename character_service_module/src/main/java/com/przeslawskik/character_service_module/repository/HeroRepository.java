package com.przeslawskik.character_service_module.repository;

import com.przeslawskik.character_service_module.documents.Hero;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends MongoRepository<Hero, ObjectId> {

}
