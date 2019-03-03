package com.example.service.user.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="payment-service")
public interface PaymentFeignClient{
	@GetMapping("/payment/message")
	String method();
}
