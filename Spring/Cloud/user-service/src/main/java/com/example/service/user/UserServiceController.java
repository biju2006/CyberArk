package com.example.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/user")
public class UserServiceController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback", groupKey = "user-service",
            commandKey = "user/go", threadPoolKey = "userThread")
    @GetMapping("/go")
    public String method() {
    	//for first steps testing:
    	//return "This is user service";
    	
    	//after having gateway we forward to test balancer & discovery: 
    	//this is not the real URL !!! it is evaluated via gateway
        String url = "http://payment-service/payment/message";
        return restTemplate.getForObject(url, String.class)+ " & user service";
    }

    public String fallback(Throwable hystrixCommand) {
        return "Payment Fall Back";
    }

}
