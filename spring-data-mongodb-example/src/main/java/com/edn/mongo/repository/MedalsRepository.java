package com.edn.mongo.repository;

import java.math.BigInteger;

import org.springframework.data.repository.Repository;

import com.edn.mongo.model.OlympicMedals;

public interface MedalsRepository extends Repository<OlympicMedals, BigInteger>, MedalsRepositoryCustom {

	public OlympicMedals findByCountryName(String name);

}