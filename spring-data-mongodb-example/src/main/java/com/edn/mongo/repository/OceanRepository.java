package com.edn.mongo.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.edn.mongo.model.Ocean;

public interface OceanRepository extends MongoRepository<Ocean, BigInteger> {
	 
}