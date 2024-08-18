package com.meda.controller.exception;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
public class UserNotFound extends RuntimeException{
	
	private static  final long serialVersionUID =1L;
	
	private final String message;
	
	public UserNotFound() {
		message="User Id not found. Please login again";
	}

	public UserNotFound(String message) {
		this.message=message;
	}
}
