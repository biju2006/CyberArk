package com.test.person;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import com.repo.ForumRepository;
import com.services.ForumStatistics;

@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
public class ForumServiceUnitTest {
	
//	@Autowired will inject the real thing...
	@MockBean
	private ForumRepository repo;
	
	//this bean depends on 'repo' - and will have it mocked...
	@Autowired
	private ForumStatistics fs;
	
	@Test
	public void testPersonAvgByForum(){
		System.out.println("DB repo is mocked:  "+fs.avgAge());
		assertTrue(fs.avgAge(-1)==-999);
	}
	
}
