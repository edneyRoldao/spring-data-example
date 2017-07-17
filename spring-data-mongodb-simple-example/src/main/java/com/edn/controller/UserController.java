package com.edn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edn.mongo.model.Contact;
import com.edn.mongo.model.Profile;
import com.edn.mongo.model.User;
import com.edn.mongo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/usuarios")
	public List<User> allUsers() {
		add();
		return service.findAllUsers();
	}
	
	private void add() {
		service.dropUsersCollection();
		
		List<Contact> contatos = new ArrayList<>();
		contatos.add(new Contact("phone", "1122-4445"));
		contatos.add(new Contact("email", "edney@mail.com"));
		
		List<Contact> contatos2 = new ArrayList<>();
		contatos2.add(new Contact("phone", "1333-8885"));
		contatos2.add(new Contact("email", "gi@mail.com"));
		
		List<Contact> contatos3 = new ArrayList<>();
		contatos3.add(new Contact("phone", "5555-0000"));
		contatos3.add(new Contact("email", "nadine@mail.com"));
		
		List<Contact> contatos4 = new ArrayList<>();
		contatos4.add(new Contact("phone", "25462-4775"));
		contatos4.add(new Contact("email", "marjorie@mail.com"));
		
		Profile profile = new Profile("35", "M");
		Profile profile2 = new Profile("28", "F");
		Profile profile3 = new Profile("14", "F");
		Profile profile4 = new Profile("1.5", "F");
		
		List<User> users = new ArrayList<>();
		users.add(new User("edney", profile, contatos));
		users.add(new User("giselle", profile2, contatos2));
		users.add(new User("nadine", profile3, contatos3));
		users.add(new User("marjorie", profile4, contatos4));
		
		service.createNewUsers(users);
		
		System.out.println("Users were added successfully !");
	}
	
}
