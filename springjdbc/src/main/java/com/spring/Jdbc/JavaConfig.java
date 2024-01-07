package com.spring.Jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springjdbc.dao.StudentDaoImpl;
import com.springjdbc.dao.StundetDao;

@Configuration
@ComponentScan(basePackages = {"com.springjdbc.dao"})
public class JavaConfig {

	@Bean(name={"ds"})
	public DataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc1");
		ds.setUsername("root");
		ds.setPassword("12345");
		
		return ds;
		
	}
	@Bean(name={"jdbcTemplate"})
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		
		return jdbcTemplate;
		
	}
	@Bean(name={"stundetDao"})
	public StundetDao getStudentDao() {
		StudentDaoImpl stundetDao=new StudentDaoImpl();
		stundetDao.setJdbctemplate(getTemplate());
		return stundetDao;
		
	}
}
