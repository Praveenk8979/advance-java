package com.meda.service;

import java.util.List;
import java.util.Optional;

import com.meda.entity.Department;


public interface DepartmentService {

	Department save(Department department);

	Optional<Department> findById(int sno);

	List<Department> findAll();

	void deleteById(int sno);
}
