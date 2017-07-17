package com.edn.mongo.model;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	@Id
	private BigInteger id;

	private String name;

	private Profile profile;

	private List<Contact> contacts;

	public User() {

	}

	public User(String name, Profile profile, List<Contact> contacts) {
		this.name = name;
		this.profile = profile;
		this.contacts = contacts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public BigInteger getId() {
		return id;
	}

}
