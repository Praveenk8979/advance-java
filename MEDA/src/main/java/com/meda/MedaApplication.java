package com.meda;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.meda.entity.Role;
import com.meda.entity.Users;
import com.meda.service.UserService;

@SpringBootApplication
public class MedaApplication extends SpringBootServletInitializer implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(MedaApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MedaApplication.class);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/static/staticResources/**")
				.addResourceLocations("classpath:/src/main/resources/static/staticResources/");
	}
	
	
	@Autowired
	UserService userService;
	
//	@PostConstruct
//	void createUser() {
//		Users user=new Users();
//		user.setUsername("praveen@gmail.com");
//		user.setPassword("praveen@123");
//		
//		Role role=new Role();
//		role.setName("ADMIN");
//		
//		user.setRoles(role);
//		userService.saveUser(user);
//	}
//	
}
