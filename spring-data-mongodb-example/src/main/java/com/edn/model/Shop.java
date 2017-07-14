package com.edn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Shop {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private Integer employeesNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEmployeesNumber() {
		return employeesNumber;
	}

	public void setEmployeesNumber(Integer employeesNumber) {
		this.employeesNumber = employeesNumber;
	}

}
