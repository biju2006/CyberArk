package com.example.springSecurity;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
	
	@RequestMapping("user/greet")
	public String greetUser(){
		return "Hello User";
	}
	
	@RequestMapping("admin/greet")
	public String greetAdmin(){
		return "Hello Admin";
	}
	
	@RequestMapping("mng/greet")
	public String greetMng(){
		return "Hello MNG";
	}
	
	@RequestMapping("roles")
	@Secured("ROLE_ADMIN")
	public String roled() {
		return "@Secured Admin";
	}
	
}
