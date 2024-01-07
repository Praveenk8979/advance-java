package com.springOrm.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springOrm.entities.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student) {
		//insert
		Integer i =(Integer) this.hibernateTemplate.save(student);
		return i;
	}
	//get the single data(object)
	public Student  getStudent(int id) {
		Student st= this.hibernateTemplate.get(Student.class, id);
		return st;
	}
	//get all students data
	public List<Student> getAllStudent(){
		List<Student> sts=this.hibernateTemplate.loadAll(Student.class);
		return sts;
	}
	// deleting the object
	@Transactional
	public void deleteStudent(int id) {
	Student std=	this.hibernateTemplate.get(Student.class, id);
		this.hibernateTemplate.delete(std);
	}
	// updating data
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
