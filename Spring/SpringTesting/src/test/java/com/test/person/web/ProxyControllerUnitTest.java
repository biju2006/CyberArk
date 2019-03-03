package com.test.person.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ProxyControllerUnitTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private RestTemplate restTeplate;
	
	@Test
	public void testPersonAvgWSValue(){
		try {
			ResultActions ra=mvc.perform(get("/proxy/person/avg"));
			ra.andExpect(status().isOk()).andExpect(content().string("null (proxy)"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
