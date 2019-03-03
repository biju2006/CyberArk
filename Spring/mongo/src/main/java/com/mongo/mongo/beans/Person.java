package com.mongo.mongo.beans;

import org.springframework.data.annotation.Id;

public class Person {

	@Id
	public String id;
	public String name;
	public String last;
	
	public Person(){}
	
	public Person(String name, String last) {
		super();
		this.id = id;
		this.name = name;
		this.last = last;
	}



	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", last=" + last + "]";
	}
	
	
}
