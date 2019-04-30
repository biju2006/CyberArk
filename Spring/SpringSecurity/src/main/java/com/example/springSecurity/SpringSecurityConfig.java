package com.example.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity  //enables roles & URL pattern mapping
@EnableGlobalMethodSecurity(securedEnabled = true)  //enables @Secured method mapping
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("user").password("{noop}123456").roles("USER");
	  auth.inMemoryAuthentication().withUser("admin").password("{noop}123456").roles("ADMIN");
	  auth.inMemoryAuthentication().withUser("mng").password("{noop}123456").roles("MNG");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/mng/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MNG')")
		.and().formLogin();	
	}

}
