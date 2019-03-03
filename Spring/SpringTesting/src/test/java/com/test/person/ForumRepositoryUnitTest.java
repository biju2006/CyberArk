package com.test.person;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.repo.PersonRepository;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
public class ForumRepositoryUnitTest {
		
	@Autowired
	private PersonRepository repo;
	
	@Test
	public void testPersonAvgRange(){
		assertTrue(repo.findPersonBetweenAge(100,0).size()==0);
	}
	
}
