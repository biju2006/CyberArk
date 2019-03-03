package com.example.mvc.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.mvc.beans.Person;
@SpringBootApplication
public class Application implements CommandLineRunner{

    //private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	
    public static void main(String args[]) {
    	SpringApplication.run(Application.class, args);
    	
    }

	@Override
	public void run(String... arg0) throws Exception {

    	//person:
    	Person p=new Person();
    	p.setName("aaa");
    	p.setAge(20);
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	HttpEntity<Person> entity = new HttpEntity<>(p,headers);
    	System.out.println(entity.getBody());
    	ResponseEntity<Person> out = restTemplate.exchange("http://localhost:8080/handle", HttpMethod.POST, entity
    		    , Person.class);
        Person p1=out.getBody();
        System.out.println(p1);
    	
    	
    	
//        Person person = restTemplate.getForObject("http://localhost:8080/person", Person.class);
//        System.out.println(person);
//        
//        Queue<Integer> queue=restTemplate.getForObject("http://localhost:8080/add/30", Queue.class);
//        for(int x: queue){
//        	System.out.println(x);
//        }
		
	}

}