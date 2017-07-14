package com.edn.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.edn.model.Pet;

public interface PetMongoRepository extends MongoRepository<Pet, String>{

}
