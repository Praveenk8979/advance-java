package com.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.entities.Student;

public class StudentDaoImpl implements StundetDao {
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	@Autowired
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public int insert(Student st) {
		 //insert query
        String query ="insert into student(id,name,city) values(?,?,?)";
      int r=  this.jdbctemplate.update(query,st.getId(),st.getName(),st.getCity());
		return r;
	}
	
	@Override
	public int change(Student st) {
		// updating data
		String query="update student set name=?,city=? where id=?";
		int r = this.jdbctemplate.update(query,st.getName(),st.getCity(),st.getId());
		
		return r;
	}


	@Override
	public int delete(int studentId) {
		// delete operation
		String query="delete from student where id=?";
		int r = this.jdbctemplate.update(query,studentId);
		
		return r;
	}    

	@Override
	public Student getStudent(int studentId) {
		// selected single student data
		String query ="select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student str = this.jdbctemplate.queryForObject(query, rowMapper,studentId);
		return str;
	}

	@Override
	public List<Student> getAllStudents() {
		//selected multiple student
		String query="select * from student";
		List<Student> qu = this.jdbctemplate.query(query, new RowMapperImpl());
		
		return qu;
	}

	

	

}
