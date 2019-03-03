package com.example.jpa.repo.beans;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Forum {

	private long id;
	private String name;
	private Collection<Person> members=new ArrayList<Person>();
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(cascade=CascadeType.PERSIST)
	public Collection<Person> getMembers() {
		return members;
	}
	public void setMembers(Collection<Person> members) {
		this.members = members;
	}
	
	
}
