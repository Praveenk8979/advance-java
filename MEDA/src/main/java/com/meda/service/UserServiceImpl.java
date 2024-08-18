package com.meda.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.meda.entity.Role;
import com.meda.entity.Users;
import com.meda.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	@Autowired
	private  UserRepository userRepository;
	
	@Autowired
	private  PasswordEncoder passwordEncoder;
	
	@Autowired
	private  RoleService roleService;

	@Override
	public List<Users> getAllUsers() {
		Collection<? extends GrantedAuthority> authorities=SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		
		String authority=authorities.iterator().next().getAuthority();
		
		if(authority.equals("SUPERADMIN")) {
			return this.userRepository.findAll();
		}else if(authority.equals("ADMIN")) {
			return this.userRepository.findAll().stream()
					.filter(e -> e.getRoles().getName().equals("ADMIN") || e.getRoles().getName().equals("USER"))
					.collect(Collectors.toList());
		}else {
			return this.userRepository.findAll().stream().filter( e -> e.getRoles().getName().equals("USER"))
					.collect(Collectors.toList());
		}
	}
 
	

	@Override
	public Users getUserById(int id) {
		return this.userRepository.findById(id).orElseThrow(()->
		 new UsernameNotFoundException("User Not Found !"));
	}

	@Override
	public String saveUser(Users user) {
		
		//check the duplicate name
		try {
			this.getByUsername(user.getUsername());
			return "Duplicate username ! must be unique";
			
		}catch(Exception e) {
			Role userRole=roleService.getRoleByName(user.getRoles().getName());
			user.setRoles(userRole);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setEnable(true);
			userRepository.save(user);
			return "Add Successfully";
		}
		
	}

	@Override
	public Users getByUsername(String username) {
		return userRepository.findByUsername(username).orElseThrow(()-> new RuntimeException("User not found"));
	}

	@Override
	public void deleteUser(String username) {
		this.userRepository.delete(getByUsername(username));
	}

	@Override
	public String updateCurrentUser(Users user) {
		
		//get user by name
		try {
			Users users=this.getByUsername(user.getUsername());
			
			//check password
			String password=users.getPassword().equals(user.getPassword()) ? users.getPassword()
					:passwordEncoder.encode(user.getPassword());
			users.setPassword(password);
			
			//check name
			users.setFirstName(user.getFirstName());
			users.setLastName(user.getLastName());
			users.setMobileNo(user.getMobileNo());
			
			userRepository.save(users);
			return "Update Successfully!";
		}catch (UsernameNotFoundException e) {
			return "User Details not found";
		}
	}



	@Override
	public String updateUser(Users user) {
		// get user by name
				try {
					Users dbUser = this.getByUsername(user.getUsername());

					// check password
					String password = dbUser.getPassword().equals(user.getPassword()) ? dbUser.getPassword()
							: passwordEncoder.encode(user.getPassword());
					dbUser.setPassword(password);

					// check name
					dbUser.setFirstName(user.getFirstName());
					dbUser.setLastName(user.getLastName());
					dbUser.setMobileNo(user.getMobileNo());

					// set user role
					dbUser.setRoles(roleService.getRoleByName(user.getRoles().getName()));

					dbUser.setEnable(user.isEnable());

					userRepository.save(dbUser);
					return "Update Successfully !";
				} catch (UsernameNotFoundException ex) {
					return "User Details not found";
				}
	}

}
