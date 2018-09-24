# phonebookapi
Phonebook API project using REST + Springboot + JAVA without a database

The project contains API calls for a telecom provider for the below 3 endpoints:
● get all phone numbers  
● get all phone numbers of a single customer  
● activate a phone number 

As the DB is missing here, the data is temporarily stored and fetched from a hashmap.
The main application can be run by running the Springbbot application class - 
com.meenal.phonebookrestapi.PhonebookRestApiApplication. 
The application uses port as specified in the application.properties file ( it's 8083 here)

Testing------
Method 1:
The endpoints can be tested using postman by firing 3 requests as per the below sample -
To get all phone numbers: GET request: http://localhost:8083/api/phonebook
To get get all phone numbers of a single customer : GET request: http://localhost:8083/api/phonebook/1  (here 1 is the customer id, initially we have 5 such customers)
To add a new phone number: PUT request: http://localhost:8083/api/phonebook   and need to provide the below Phonebook object in body.
{
        "name": "Kristie",
        "phoneNumbers": [
            "765765",
            "378873"
        ]
    }

Method 2:
We can simply run the Test class which acts as a application and we need not run the main application class with this.
Run test class com.meenal.phonebookrestapi.PhonebookRestApiApplicationTests using JUnit/Testng 
It has 3 test methods, each one for the above 3 APIs. TestRestTemplate is used here to test the APIs.


