package com.ednTiSolutions.springBoot.webApiWithMongo.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Phone {

	private String localCode;
	private String number;
	
	public Phone() {}
	
	public Phone(String code, String num) {
		localCode = code;
		number = num;
	}

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
