package com.edn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edn.model.Pet;
import com.edn.service.PetService;

@RestController
public class PetController {

	@Autowired
	private PetService service;

	@GetMapping("/pets")
	public List<Pet> getAnimals() {
		addPets();
		return service.getPets();
	}

	private void addPets() {
		Pet pet = new Pet("Draco", "1");
		Pet pet2 = new Pet("Thor", "2");
		Pet pet3 = new Pet("Jully", "7");
		Pet pet4 = new Pet("Gigante", "5");
		service.createNewPet(pet);
		service.createNewPet(pet2);
		service.createNewPet(pet3);
		service.createNewPet(pet4);
	}

}
