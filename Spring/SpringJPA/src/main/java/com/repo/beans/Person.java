package com.repo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

	private Long id;
	private String name;
	private int age;
	
	public Person(){}
	
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(nullable=false)
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
