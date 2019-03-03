package com.example.jpa.repo.beans;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class People {

	private long id;
	private Collection<Person> persons=new ArrayList<Person>();
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	public Collection<Person> getPersons() {
		return persons;
	}
	public void setPersons(Collection<Person> persons) {
		this.persons = persons;
	}
	
	
}
