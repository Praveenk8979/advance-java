package com.meda.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meda.entity.Users;

@Service
public interface UserService {
	
	String saveUser(Users user);
	
	Users getByUsername(String username);
	
	void deleteUser(String username);
	
	String updateCurrentUser(Users user);
	
	List<Users> getAllUsers();
	
	String updateUser(Users user);
	
	Users getUserById(int id);
	
	
	

}
