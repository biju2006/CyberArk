package com.repo;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import com.repo.beans.Person;

public interface PersonRepository extends CrudRepository<Person,Long>{
	
	List<Person> findPersonsByAge(int age); 
	List<Person> findPersonsByName(String name);
	@Query("select per from Person per where per.age >= ?1 and per.age <= ?2")
	List<Person> findPersonBetweenAge(int from, int to);
	List<Person> findPersonsByAgeGreaterThan(int age);
}
