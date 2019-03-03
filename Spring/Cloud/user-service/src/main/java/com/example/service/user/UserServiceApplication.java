package com.example.service.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker 
@EnableHystrix  //- in case there are several CircuitBreaker impl. this is how we specify Histrix.
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class UserServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
}

@Configuration
class Config {
	@LoadBalanced  //all activity done on this restTemplate is monitored by CircuitBreaker
	@Bean
	public RestTemplate testTemplate(){
		return new RestTemplate();
	}
}
