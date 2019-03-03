package com.mongo.mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.mongo.beans.Person;

public interface PersonMongoRepository extends MongoRepository<Person, Long>{
	Person findByName(String name);
}
