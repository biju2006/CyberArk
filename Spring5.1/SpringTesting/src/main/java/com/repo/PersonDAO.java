package com.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.repo.beans.Person;

@Repository
public class PersonDAO {
	
	@Autowired
	private PersonRepository repo;

	public long addPerson(Person p){
		if(p.getAge()>=0&&p.getAge()<=120){
			repo.save(p);
			return p.getId();
		}
		return -999;
	}
	
	public Iterable<Person> getAll(){
		return repo.findAll();
	}
	
	public Person getById(long id){
		return repo.findById(id).get();
	}
	
	public Iterable<Person> getPersonBetweanAges(int from,int to){
		return repo.findPersonBetweenAge(from, to);
	}
	
	public Iterable<Person> getPersonOlderThan(int from){
		return repo.findPersonsByAgeGreaterThan(from);
	}
	
	
	
	
}
