package com.example.service.payment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
@RequestMapping(value="/payment")
public class PaymentServiceController {

	@Value("${eureka.instance.instanceId}")
	private String instanceID;
	
	@GetMapping("/message")
	public String hello(){
		System.out.println("payment-service invoked");
		return "This is payment service (server instanceId: "+instanceID+")";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceController.class, args);
	}
}
