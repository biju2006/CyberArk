package com.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.jpa.repo.PeopleRepository;
import com.example.jpa.repo.beans.People;
import com.example.jpa.repo.beans.Person;

@SpringBootApplication
public class SpringJpaApplication{
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringJpaApplication.class, args);
		PeopleRepository repo=ctx.getBean(PeopleRepository.class);

		People p1=new People();
		p1.getPersons().add(new Person("aaa",10));
		p1.getPersons().add(new Person("bbb",20));
		long id1=repo.save(p1).getId();
		
		People p2=new People();
		p2.getPersons().add(new Person("ccc",30));
		p2.getPersons().add(new Person("ddd",40));
		p2.getPersons().add(new Person("eee",50));
		long id2=repo.save(p2).getId();
		
		repo.getOne(id1).getPersons().stream().forEach(System.out::println);
		System.out.println("____________");
		repo.getOne(id2).getPersons().stream().forEach(System.out::println);
	}

}

