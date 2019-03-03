package com.test.person.web;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import com.repo.beans.Person;

@RunWith(SpringRunner.class)
@JsonTest
public class ClientControllerUnitTest {
	
	@Autowired
	private JacksonTester<Person> test;
	
	@Test
	public void testPersonJsonInfo(){
		//perform both structural & content checks on JSON 
		try {
			Person toCheckAgainst=new Person();
			toCheckAgainst.setId(-999L);
			toCheckAgainst.setName("Dummy");
			toCheckAgainst.setAge(0);
			toCheckAgainst.setGender(null);
			
			//fetch REAL person from DB as JSON through REST
			URL url=new URL("http://localhost:8080/person/info/1");
			String json="";
			try(BufferedReader in=new BufferedReader(new InputStreamReader(url.openStream()))){
				json=in.readLine();
				System.out.println("Got from server: "+json);
			}catch(Exception e){
				assertTrue("Failed connecting to server", true);
			}
			//check structure & content
			test.parse(json).assertThat().hasFieldOrProperty("age")
									     .hasFieldOrProperty("gender")
									     .isNotEqualTo(toCheckAgainst);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
