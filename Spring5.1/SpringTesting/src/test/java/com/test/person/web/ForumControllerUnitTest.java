package com.test.person.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ForumControllerUnitTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testPersonAvgWSValue(){
		try {
			ResultActions ra=mvc.perform(get("/person/age/avg"));
			ra.andExpect(status().isOk()).andExpect(content().string("36.44444444444444")).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8) );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPersonAvgWSMatch(){
		try {
			
			ResultActions ra=mvc.perform(get("/person/age/avg"));
			BaseMatcher<String> bm=new BaseMatcher<String>() {
				
				@Override
				public void describeTo(Description d) {
					d.appendText("Checking person avg age double value");
				}
				
				@Override
				public boolean matches(Object value) {
					if(value instanceof String){
						return Double.parseDouble((String)value)>=0;
					}
					return false;
				}
			};
			ra.andExpect(status().isOk()).andExpect(content().string(bm));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
