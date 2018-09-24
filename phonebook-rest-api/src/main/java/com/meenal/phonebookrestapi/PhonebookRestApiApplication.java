package com.meenal.phonebookrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class is the starting point of the application. 
 * Port for running the application is in application.properties file
 *
 */
@SpringBootApplication(scanBasePackages = {"com.meenal"})
public class PhonebookRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhonebookRestApiApplication.class, args);
	}
}
