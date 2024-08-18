package com.meda.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meda.entity.Role;


@Service
public interface RoleService {

	List<Role> getAllRoles();

	Role getRoleByName(String roleName);

	Role getRoleById(Integer roleId);
	
}
