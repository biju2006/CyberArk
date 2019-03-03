package com.example.mongo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongo.beans.Person;


public interface PersonMongoRepository extends MongoRepository<Person, String>{
	
	List<Person> findByName(String name);
}
