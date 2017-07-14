package com.edn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edn.model.Pet;
import com.edn.mongo.repository.PetMongoRepository;

@Service
public class PetService {

	@Autowired
	private PetMongoRepository repository;

	
	public void createNewPet(Pet animal) {
		repository.insert(animal);
	}
	
	public List<Pet> getPets() {
		return repository.findAll();
	}

}
