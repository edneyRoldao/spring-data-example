package com.ednTiSolutions.springBoot.webApiWithMongo.service;

import com.ednTiSolutions.springBoot.webApiWithMongo.model.Guest;

import java.util.List;

public interface GuestService {

    Guest find(String name);
    List<Guest> findByAge(String age);
    List<Guest> find();
    void create(Guest guest);

}
