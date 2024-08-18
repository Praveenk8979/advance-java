package com.meda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.meda.entity.Role;
import com.meda.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

	@Autowired
	private  RoleRepository roleRepository;
	
	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role getRoleByName(String roleName) { 
		List<Role> roleByName=this.roleRepository.findByName(roleName);
		
		if(!roleByName.isEmpty()) {
			return roleByName.get(0);
		}
		return null;
	}

	@Override
	public Role getRoleById(Integer roleId) {
		Optional<Role> findById=this.roleRepository.findById(roleId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

}
