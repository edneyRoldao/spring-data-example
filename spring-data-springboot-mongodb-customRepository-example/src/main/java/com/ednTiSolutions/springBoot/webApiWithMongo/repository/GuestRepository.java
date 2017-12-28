package com.ednTiSolutions.springBoot.webApiWithMongo.repository;

import com.ednTiSolutions.springBoot.webApiWithMongo.model.Guest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GuestRepository extends MongoRepository<Guest, String> {

    public Guest findByName(String name);
    public List<Guest> findByAge(String age);

}
