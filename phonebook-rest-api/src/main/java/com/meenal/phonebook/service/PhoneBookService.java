package com.meenal.phonebook.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;

import com.meenal.phonebook.bean.PhoneBook;


public class PhoneBookService {

	static HashMap<Integer,PhoneBook> phoneBookMap = getPhoneBookMap();
	
	public PhoneBookService() {
		super();
		// creating a sample data set as we do not have DB setup. Using hashmap to store the phonebook.
		if(phoneBookMap == null) {
			phoneBookMap = new HashMap<Integer,PhoneBook>();
			PhoneBook customer1 = new PhoneBook( "Alex", Arrays.asList("123123","456456"));
			PhoneBook customer2 = new PhoneBook( "Brat", Arrays.asList("234234"));
			PhoneBook customer3 = new PhoneBook( "Celina", Arrays.asList("678678"));
			PhoneBook customer4 = new PhoneBook( "Dan", Arrays.asList("989898","567567"));
			PhoneBook customer5 = new PhoneBook( "Eva", Arrays.asList("345456","567895","765789"));
			phoneBookMap.put(1, customer1);
			phoneBookMap.put(2, customer2);
			phoneBookMap.put(3, customer3);
			phoneBookMap.put(4, customer4);
			phoneBookMap.put(5, customer5);
		}		
	}


	/**
	 * 
	 * Method to get all the phone numbers
	 * @return Hashmap with name and numbers
	 */
	public HashMap getAllNumbers() {		
		return phoneBookMap;
	}


	/**
	 * Method to get phone numbers of a particular customer
	 * @param id  -- customer id
	 * @return list of phone numbers for that customer
	 */
	public List getNumbersOfCustomer(Integer id) {
		List numbers = phoneBookMap.get(id).getPhoneNumbers();
		return numbers;
	}

	/**
	 * Methiod to add new phonebook entry
	 * @param phoneNum
	 * @return PhoneBook object
	 */
	public PhoneBook addPhoneNumber(PhoneBook phoneNum) {
		phoneNum.setName(phoneNum.getName());
		phoneNum.setPhoneNumbers(phoneNum.getPhoneNumbers());
		phoneBookMap.put(phoneBookMap.size()+1, phoneNum);
		return phoneBookMap.get(phoneBookMap.size()+1);
	}

	private static HashMap<Integer, PhoneBook> getPhoneBookMap() {
		return phoneBookMap;
	}

} 
