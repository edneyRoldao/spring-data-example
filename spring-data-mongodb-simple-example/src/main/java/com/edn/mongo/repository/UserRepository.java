package com.edn.mongo.repository;

import java.util.List;

import com.edn.mongo.model.User;

public interface UserRepository {

	void createNewUser(User user);
	
	User findUserByName(String name);
	
	List<User> findAllUsers();
	
	void createNewUsers(List<User> users);
	
}
