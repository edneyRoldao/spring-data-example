package com.ednTiSolutions.springBoot.webApiWithMongo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "guests")
public class Guest {

    @Id
    @JsonIgnore
    private ObjectId id;

    private String age;
    private String name;
    private String docNumber;
    private List<Phone> phones;

    
    public Guest( ) {
    		phones = new ArrayList<>();
    }

	public Guest(String age, String name, String docNumber, List<Phone> phones) {
		super();
		this.age = age;
		this.name = name;
		this.docNumber = docNumber;
		this.phones = phones;
	}


	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
}
