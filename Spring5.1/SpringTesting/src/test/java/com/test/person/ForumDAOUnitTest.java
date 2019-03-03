package com.test.person;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import com.repo.PersonDAO;
import com.repo.beans.Person;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ForumDAOUnitTest {
	
	@Autowired 
	private PersonDAO repo;
		
	@Test
	public void testPersonAvgByForum(){
		Person p=new Person();
		p.setName("Newbe");
		p.setGender("male");
		p.setAge(-10);
		assertEquals(-999,repo.addPerson(p));
	}
	
}
