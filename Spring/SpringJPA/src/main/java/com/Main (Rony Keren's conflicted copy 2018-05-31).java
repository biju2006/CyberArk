package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repo.PersonDAO;
import com.repo.beans.Person;

@RestController
@SpringBootApplication
@Transactional
public class Main {

	@RequestMapping("greet")
	public String greet(){
		return "Hello";
	}
	
	
	
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Main.class, args);
		PersonDAO repo=context.getBean(PersonDAO.class);
		System.out.println("Addding new person");
		Person p=new Person("Naftali",27);
		repo.addPerson(p);
		System.out.println("view all:");
		repo.getAll().forEach(e->System.out.println(e.getName()+" "+e.getAge()));
		System.out.println("view all with age between 37-42:");
		repo.getPersonBetweanAges(37, 42).forEach(e->System.out.println(e.getName()+" "+e.getAge()));
		
	}
}
