package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDaoImp;
@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.dao"})
public class javaConfig {
	//create the DriverManager
	@Bean("ds")
	public DriverManagerDataSource getSourceData() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("saks123ham@MYSQL");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(getSourceData());
		return jdbcTemplate;
	}

	/*
	@Bean("studentDao")
	public StudentDaoImp getStudent() {
		StudentDaoImp student=new StudentDaoImp();
		student.setJdbcTemplate(getJdbcTemplate());
		return student;
		
	}
	*/

}
