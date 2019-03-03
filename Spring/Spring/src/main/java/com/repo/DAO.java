package com.repo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource(value = {"classpath:application.properties"})
public class DAO {
	
	@Autowired
	private Environment env;
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@Value("${jdbc.driverClassName}")
	private String driverClass;
	
	
	@Bean
	public DataSource getDataSource() {
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
	  dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
	  dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
	  dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
	  return dataSource;
	}
	
	@Bean
	@Autowired
	public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  jdbcTemplate.setResultsMapCaseInsensitive(true);
	  return jdbcTemplate;
	}
	
	public int count(){
	    return this.jdbcTemplate.queryForObject("select count(*) from person",Integer.class);
	}    
}
