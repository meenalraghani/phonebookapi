package com.meenal.phonebookrestapi;

import java.util.Arrays;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.meenal.phonebook.bean.PhoneBook;

/**
 * This is the test class for testing the application
 * TestRestTemplate is used in order to test all the 3 API calls
 * This class can be run without running the main class as we are starting the application here with a random port
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PhonebookRestApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PhonebookRestApiApplicationTests {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testGetPhoneBook() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:"+port+"/api/phonebook",
				HttpMethod.GET, entity, String.class);

		String expected = "{\"1\":{\"name\":\"Alex\",\"phoneNumbers\":[\"123123\",\"456456\"]},\"2\":{\"name\":\"Brat\",\"phoneNumbers\":[\"234234\"]},\"3\":{\"name\":\"Celina\",\"phoneNumbers\":[\"678678\"]},\"4\":{\"name\":\"Dan\",\"phoneNumbers\":[\"989898\",\"567567\"]},\"5\":{\"name\":\"Eva\",\"phoneNumbers\":[\"345456\",\"567895\",\"765789\"]}}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	@Test
	public void testGetPhoneBookForCustomer() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:"+port+"/api/phonebook/3",
				HttpMethod.GET, entity, String.class);

		String expected = "[\"678678\"]";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}


@Test
public void addPhoneNumber() throws JSONException {
	PhoneBook newPhone = new PhoneBook("Fin", Arrays.asList("679854","434543"));
	HttpEntity<PhoneBook> entity = new HttpEntity<PhoneBook>(newPhone, headers);

	ResponseEntity<String> response = restTemplate.exchange(
			"http://localhost:"+port+"/api/phonebook",
			HttpMethod.PUT, entity, String.class);
	System.out.println(response.getStatusCode().toString());
	JSONAssert.assertEquals("200", response.getStatusCode().toString(), false);
}

}


