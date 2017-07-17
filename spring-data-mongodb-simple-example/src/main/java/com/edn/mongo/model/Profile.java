package com.edn.mongo.model;

public class Profile {

	private String age;

	private String gender;

	public Profile() {

	}

	public Profile(String age, String gender) {
		this.age = age;
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
