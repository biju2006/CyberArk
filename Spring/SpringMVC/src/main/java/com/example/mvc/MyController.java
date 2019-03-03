package com.example.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.beans.Person;


@RestController
public class MyController {
	@RequestMapping(value="/greet", method=RequestMethod.GET)
	public String greet(@RequestParam(value= "name",defaultValue="No One")String name){
		return "Hello "+name+" !!!";
	}
	
	@RequestMapping("/sum/{num1}/{num2}")
	public String sum(@PathVariable("num1")int x,@PathVariable("num2")int y){
		return x+y+"";
	}
	
	@RequestMapping("/person/{name}/{age}")
	public ResponseEntity<?> getPerson(@PathVariable("name")String name,@PathVariable("age") int age){
		if(age<0||age>120){
			return new ResponseEntity<String>("wrong age value...",HttpStatus.BAD_REQUEST);
		}
		Person p=new Person();
		p.setName(name);
		p.setAge(age);
		return new ResponseEntity<Person>(p,HttpStatus.OK);
	}
	
	@RequestMapping("/people")
	public List<Person> getPeople(){
		List<Person> people=new ArrayList<>();
		Person p=new Person();
		p.setName("David");
		p.setAge(20);
		people.add(p);
		Person p2=new Person();
		p2.setName("Ann");
		p2.setAge(30);
		people.add(p2);
		return people;
	}
	
	@RequestMapping(value="/handle", consumes="application/json", method=RequestMethod.POST)
	public Person handlePerson(@RequestBody Person p){
		p.setName(p.getName()+"(handled by server....)");
		return p;
	}
	
	
}