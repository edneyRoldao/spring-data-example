package com.ednTiSolutions.springBoot.webApiWithMongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ednTiSolutions.springBoot.webApiWithMongo.model.Guest;
import com.ednTiSolutions.springBoot.webApiWithMongo.repository.NewGuestRepository;

@RestController
@RequestMapping("/api/")
public class NewGuestController {
	
	private NewGuestRepository repository;
	
	@Autowired
	public NewGuestController(NewGuestRepository repository) {
		this.repository = repository;
	}
	
    @PostMapping("guest/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createGuest(@RequestBody Guest guest) {
    		repository.save(guest);
    		System.out.println("New Guest with list of phones has been created!");
    }
    
    @PutMapping("guest/change")
    @ResponseStatus(HttpStatus.OK)
    public void updateGuest(@RequestBody Guest guest) {
    		repository.testUpdate(guest.getDocNumber(), guest.getPhones().get(0));
    		System.out.println("The guest was updated with custom repository!");
    }

}
