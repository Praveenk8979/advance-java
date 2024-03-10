package com.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
