package com.edn.mongo.repository;

public interface MedalsRepositoryCustom {

	public int getBronzeCount(String countryName);

	public int getSilverCount(String countryName);

	public int getGoldCount(String countryName);

}