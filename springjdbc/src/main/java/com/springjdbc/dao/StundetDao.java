package com.springjdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.entities.Student;

public interface StundetDao {
	public int insert(Student st);
	public int change(Student st);
	public int delete(int studentId);
	public Student getStudent(int studentId);
	public List<Student> getAllStudents();
	

}
