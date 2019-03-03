package com.example.service.user.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentClientController {

	@Autowired
	private PaymentFeignClient client;
	
	@RequestMapping("/feign")
	public String test(){
		return client.method();
	}
}
