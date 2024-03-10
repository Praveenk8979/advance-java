package com.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.student.dao.StudentRepo;
import com.student.entity.Student;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepo studentRepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Student st1=new Student("Praveen ","Chauhan","praveenchauhan@gmail.com","7887675634");
//		studentRepo.save(st1);
//		
//		Student st2=new Student("Deepak ","Thakur","deepakthakur@gmail.com","8126527695");
//		studentRepo.save(st2);
//		
//		Student st3=new Student("Abhi ","Chauhan","abhichauhan@gmail.com","7934235465");
//		studentRepo.save(st3);
//		
//		Student st4=new Student("Himanshi ","Chauhan","himanshichauhan@gmail.com","7887567845");
//		studentRepo.save(st4);
	}

}
