package com.ednTiSolutions.springBoot.webApiWithMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ednTiSolutions.springBoot.webApiWithMongo.model.Guest;

public interface NewGuestRepository extends MongoRepository<Guest, String>, CustomGuestRepository {

}
