package com.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProxyController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("proxy/person/avg")
	public String proxyPerson(HttpServletRequest req){
		return restTemplate.getForObject("http://localhost:8080/person/age/avg", String.class)+" (proxy)";
	}
	
	@RequestMapping("proxy/forum/avg")
	public String proxyForum(HttpServletRequest req){
		return restTemplate.getForObject("http://localhost:8080/forum/age/avg", String.class)+" (proxy)";
	}
}
