package com.edn.mongo.service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.edn.mongo.model.User;
import com.edn.mongo.repository.UserRepository;

@Service
public class UserService implements UserRepository {

	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public void createNewUser(User user) {
		mongoOperations.insert(user);
	}

	@Override
	public User findUserByName(String name) {
		return mongoOperations.findOne(query(where("name").is(name)), User.class);
	}

	@Override
	public List<User> findAllUsers() {
		return mongoOperations.findAll(User.class);
	}

	@Override
	public void createNewUsers(List<User> users) {
		mongoOperations.insert(users, User.class);
	}

	public void dropUsersCollection() {
		if (mongoOperations.collectionExists(User.class)) {
			mongoOperations.dropCollection(User.class);
		}
	}

}
