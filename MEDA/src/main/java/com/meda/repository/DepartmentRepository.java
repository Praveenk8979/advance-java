package com.meda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meda.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
