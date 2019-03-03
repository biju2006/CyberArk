package com.example.serverless;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class ServerlessApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerlessApplication.class, args);
	}
	
	
	@Bean
	public Function<Flux<String>,Flux<Integer>> letterCount(){
		return flux -> flux.map(value->value.length());
	}
	
	@Bean
	public Supplier<Flux<Integer>> randomize(){
		return () -> Flux.just((int)(Math.random()*101));
	}
	
	@Bean
	public Consumer<Flux<String>> print(){
		return flux -> flux.next().subscribe(System.out::println);
	}
	
}
