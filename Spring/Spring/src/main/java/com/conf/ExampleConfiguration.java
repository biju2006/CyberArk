package com.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.beans.PrototypeBean;

@Configuration
public class ExampleConfiguration {
	@Bean//("proto6")
	public PrototypeBean proto6(){
		PrototypeBean p=new PrototypeBean();
		p.x=6;
		return p;
	}
}
