package com.mongo.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mongo.mongo.beans.Person;
import com.mongo.mongo.repo.PersonMongoRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private PersonMongoRepository mongo;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		mongo.deleteAll();
		mongo.save(new Person("Bob","Smith"));
		mongo.save(new Person("Alice","Smith"));
		for(Person p:mongo.findAll()){
			System.out.println(p);
		}
		System.out.println();
		System.out.println(mongo.findByName("Alice"));
	}
}
