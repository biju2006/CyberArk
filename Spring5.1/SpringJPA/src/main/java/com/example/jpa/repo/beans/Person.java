package com.example.jpa.repo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Person {

	private Long id;
	private String name;
	private int age;
	private String gender;
	private People p;
	
	
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

	@Column
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	@ManyToOne
	public People getP() {
		return p;
	}

	public void setP(People p) {
		this.p = p;
	}
	
	

}
