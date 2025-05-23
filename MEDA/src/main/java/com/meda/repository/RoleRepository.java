package com.meda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meda.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	List<Role> findByName(String name);

}
