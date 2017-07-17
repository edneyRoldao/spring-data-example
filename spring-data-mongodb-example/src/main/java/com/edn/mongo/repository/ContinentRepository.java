package com.edn.mongo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.edn.mongo.model.Continent;

public interface ContinentRepository extends CrudRepository<Continent, Long> {

	public Continent findByName(String name);

	public List<Continent> findByNameStartingWithIgnoreCase(String start);

}