package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.PersonStatistics;
import com.repo.beans.Person;
import com.services.ForumStatistics;

@RestController
public class PersonController {
	
	@Autowired
	private PersonStatistics ps;
	@Autowired
	private ForumStatistics fs;
	
	@RequestMapping(value="person/info/{id}")
	public ResponseEntity<Person> findPerson(@PathVariable("id")long id){
		return new ResponseEntity<Person>(ps.getById(id),HttpStatus.OK);
	}
	
	@RequestMapping(value="person/age/avg")
	public ResponseEntity<Double> getPersonsAvgAge(){
		return new ResponseEntity<Double>(ps.avgAge(),HttpStatus.OK);
	}
	
	@RequestMapping("forum/age/avg")
	public ResponseEntity<Double> getForumsPersonAvgAge(){
		return new ResponseEntity<Double>(fs.avgAge(),HttpStatus.OK);
	}
}
