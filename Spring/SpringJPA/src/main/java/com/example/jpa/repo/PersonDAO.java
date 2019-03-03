package com.example.jpa.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jpa.repo.beans.Person;

@Repository
public class PersonDAO {
//	@PersistenceContext
//	private EntityManager em;
		
	@Autowired
	private PersonRepository repo;

	public void addPerson(Person p){
		if(p.getAge()>=0&&p.getAge()<=120)
			repo.save(p);
	}
	
	public Iterable<Person> getAll(){
		return repo.findAll();
	}
	
	public Iterable<Person> getPersonBetweanAges(int from,int to){
		return repo.findPersonBetweenAge(from, to);
	}
	
	public Iterable<Person> getPersonOlderThan(int from){
		return repo.findPersonsByAgeGreaterThan(from);
	}
	
}
