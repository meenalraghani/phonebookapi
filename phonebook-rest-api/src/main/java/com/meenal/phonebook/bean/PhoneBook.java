package com.meenal.phonebook.bean;

import java.util.List;

/**
 * POJO class for the phonebook api. 
 *
 */
public class PhoneBook {
	String name;
	List<String> phoneNumbers;
	
	
	public PhoneBook(String name, List<String> phoneNumbers) {
		super();
		this.name = name;
		this.phoneNumbers = phoneNumbers;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
}
