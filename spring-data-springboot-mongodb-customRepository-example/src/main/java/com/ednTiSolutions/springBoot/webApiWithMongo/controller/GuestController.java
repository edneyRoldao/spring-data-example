package com.ednTiSolutions.springBoot.webApiWithMongo.controller;

import com.ednTiSolutions.springBoot.webApiWithMongo.model.Guest;
import com.ednTiSolutions.springBoot.webApiWithMongo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class GuestController {

    private GuestService service;

    @Autowired
    public GuestController(GuestService service) {
        this.service = service;
    }

    @GetMapping("guest/{name}")
    public Guest getGuest(@PathVariable String name) {
        return service.find(name);
    }

    @GetMapping("guests/{age}")
    public List<Guest> getGuests(@PathVariable String age) {
        return service.findByAge(age);
    }

    @GetMapping("guests")
    public List<Guest> allGuests() {
        return service.find();
    }

    @PostMapping("guest")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Guest guest) {
        service.create(guest);
        System.out.println("a guest has been created !");
    }

}
