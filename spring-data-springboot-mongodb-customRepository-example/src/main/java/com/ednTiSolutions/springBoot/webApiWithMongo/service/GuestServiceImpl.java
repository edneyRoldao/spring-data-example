package com.ednTiSolutions.springBoot.webApiWithMongo.service;

import com.ednTiSolutions.springBoot.webApiWithMongo.model.Guest;
import com.ednTiSolutions.springBoot.webApiWithMongo.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository repository;


    public Guest find(String name) {
        return repository.findByName(name);
    }

    public List<Guest> findByAge(String age) {
        return repository.findByAge(age);
    }

    public List<Guest> find() {
        return repository.findAll();
    }

    public void create(Guest guest) {
        repository.insert(guest);
    }

}
