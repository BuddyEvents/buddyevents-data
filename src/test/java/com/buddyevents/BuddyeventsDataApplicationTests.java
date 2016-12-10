package com.buddyevents;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.buddyevents.node.entity.Person;
import com.buddyevents.repository.PersonRepository;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class BuddyeventsDataApplicationTests {

	@Autowired
	TestRestTemplate testRestTemplate;
	@Autowired
	PersonRepository personRepository;
    private JacksonTester<Person> json;

	@Before
	public void setup(){
		Person person= new Person();
		person.setName("SG");
		person.setEmail("eml2@");
		personRepository.save(person);
	}
    @Test
    public void test() {
		Map<String, String> urlVariables= new HashMap<String,String>();
		urlVariables.put("name", "SG");
		
     ResponseEntity<Person>  per=  this.testRestTemplate.getForEntity(
            "/people/search/findByName", Person.class,urlVariables);
     Assert.assertEquals("not expected",200, per.getStatusCodeValue());
    // Assert.assertEquals("expected not equals", per.getBody().getName(),"SG");
    }

    @After
    public void delete(){
    	
    	personRepository.delete(personRepository.findByName("SG"));
    }
}
