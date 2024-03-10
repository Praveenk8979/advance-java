package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentRepo;
import com.student.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	private StudentRepo studentRepo;
	
	


	public StudentServiceImpl(StudentRepo studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}




	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}




	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}




	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(id).get();
	}




	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}




	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(id);
	}

	
}
