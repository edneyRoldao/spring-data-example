package com.edn.mongo.model;

public class Contact {

	private String category;

	private String value;

	public Contact() {

	}

	public Contact(String category, String value) {
		this.category = category;
		this.value = value;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
