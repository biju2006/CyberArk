package com.example.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.mongo.beans.Person;
import com.example.mongo.repo.PersonMongoRepository;

@SpringBootApplication
public class SpringMongoApplication implements CommandLineRunner {

	@Autowired
	private PersonMongoRepository mongo;

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		mongo.deleteAll();
		mongo.save(new Person("Haim", "Cohen"));
		mongo.save(new Person("Bar", "Levy"));
		for (Person p : mongo.findAll()) {
			System.out.println(p);
		}
		System.out.println();
		System.out.println(mongo.findByName("Haim"));
	}
}
