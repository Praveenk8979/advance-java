package com.meda.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.meda.entity.Users;
import com.meda.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Autowired
	private  CustomAuthentication customAuthentication;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	UserDetailsService userDetailsService(UserRepository userRepository) {
		return username -> {
			Users users = userRepository.findByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException("User not found with name :" + username));
			return new User(users.getUsername(), users.getPassword(), users.isEnable(), true, true, true,
					getAuthorities(users));
		};
	}

	@Bean
	AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class).build();
	}

	public static final String[] staticResources = { "/staticResources/styleSheets/**", "/staticResources/images/**" };

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).authorizeRequests(request -> {
			request.antMatchers(HttpMethod.GET, staticResources).permitAll();
			request.anyRequest().authenticated();
		}).formLogin(form -> {
			form.loginPage("/login").usernameParameter("username").passwordParameter("password")
					.defaultSuccessUrl("/home");
			form.permitAll();
			form.successHandler(customAuthentication);
		}).logout(LogoutConfigurer::permitAll).headers(header -> header.frameOptions().sameOrigin());
		return http.build();
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Users users) {
		return Arrays.asList(new SimpleGrantedAuthority(users.getRoles().getName()));
	}

}
