package com.meenal.phonebook.controller;

import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meenal.phonebook.bean.PhoneBook;
import com.meenal.phonebook.service.PhoneBookService;

/**
 * This is the controller class for phonebook rest api service. 
 * We have mappings for 3 requests here
 * ● get all phone numbers  
 * ● get all phone numbers of a single customer  
 * ● activate a phone number
 *
 */
@Controller
@Path("/api/phonebook")
public class PhoneBookController {
	PhoneBookService phoneBookService = new PhoneBookService();


	@RequestMapping(method = RequestMethod.GET, value="/api/phonebook", produces = { "application/json"})
	@ResponseBody
	public HashMap getPhoneNumbers() {
		HashMap numbers = phoneBookService.getAllNumbers();		
		return numbers;
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/api/phonebook/{id}", produces = { "application/json"})
	@ResponseBody	
	public List getPhoneNumberOfCustomer(@PathVariable("id") Integer id) {
		List numbersOfCustomer = phoneBookService.getNumbersOfCustomer(id);
		return numbersOfCustomer;
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/api/phonebook", produces = { "application/json"})
	@ResponseBody		
	public PhoneBook addPhoneNumber(@RequestBody PhoneBook phoneNum) {
		return phoneBookService.addPhoneNumber(phoneNum);
		
	}
	
	
}
