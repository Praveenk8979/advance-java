package com.meda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meda.entity.Department;
import com.meda.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private  DepartmentRepository departmentRepository;
	
	@Override
	public Department save(Department department) {
		
		return departmentRepository.save(department);
	}

	@Override
	public Optional<Department> findById(int sno) {
		return departmentRepository.findById(sno);
	}

	@Override
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	public void deleteById(int sno) {
		departmentRepository.deleteById(sno);
		
	}

}
