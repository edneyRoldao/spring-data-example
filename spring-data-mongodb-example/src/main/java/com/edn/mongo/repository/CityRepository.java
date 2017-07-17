package com.edn.mongo.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.edn.mongo.model.City;

public interface CityRepository extends CrudRepository<City, BigInteger> {

	public City findByName(String name);

}