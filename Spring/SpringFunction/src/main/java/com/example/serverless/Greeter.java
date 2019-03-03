package com.example.serverless;

import java.util.function.Function;

import org.springframework.stereotype.Component;

@Component
public class Greeter implements Function<String, String> {

	@Override
	public String apply(String name) {
		return "Hi "+name+", It is very nice to meet you!";
	}

}
