package com.springOrm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springOrm.dao.StudentDao;
import com.springOrm.entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao sd = context.getBean("studentDao", StudentDao.class);

//        Student st=new Student(0007,"Praveen Chauhan","Aligarh");
//        int r = sd.insert(st);
//        System.out.println("Done.."+r);

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean go = true;
		while (go) {
			System.out.println("Press 1 for add new student");
			System.out.println("Press 2 for display all student");
			System.out.println("Press 3 for get details of single student");
			System.out.println("Press 4 for delete student");
			System.out.println("Press 5 for update student");
			System.out.println("Press 6 for exit");

			try {

				int input = Integer.parseInt(br.readLine());
//            	if(input==1) {
				// add a new student
//            	}else if(input==2){
				// display
				// }

				switch (input) {
				case 1:
					// add a new student
					// taking inputs from user
					System.out.println("Enter user id :");
					int uId = Integer.parseInt(br.readLine());

					System.out.println("Enter user name :");
					String uName = br.readLine();

					System.out.println("Enter user city :");
					String uCity = br.readLine();

					// creating student object and setting values
					Student s = new Student();
					s.setStudentId(uId);
					s.setStudentName(uName);
					s.setStudentCity(uCity);

					// saving student object to database by calling insert of student dao
					int r = sd.insert(s);
					System.out.println(r + " Student added..");
					System.out.println("*********************************");
					System.out.println();
					break;
				case 2:
					// display all student
					System.out.println("***********************************");
					List<Student> allStudent = sd.getAllStudent();
					for (Student st : allStudent) {
						System.out.println("Id :" + st.getStudentId());

						System.out.println("Name :" + st.getStudentName());

						System.out.println("City :" + st.getStudentCity());

						System.out.println("_________________________________");
					}
					System.out.println("************************************");
					break;
				case 3:
					// get single student data
					System.out.println("Enter user id :");
					int userId = Integer.parseInt(br.readLine());
					Student std = sd.getStudent(userId);
					System.out.println("____________________________");
					System.out.println("Id :" + std.getStudentId());

					System.out.println("Name :" + std.getStudentName());

					System.out.println("City :" + std.getStudentCity());

					System.out.println("_________________________________");
					break;
				case 4:
					// delete student
					System.out.println("Enter user id :");
					int id = Integer.parseInt(br.readLine());
					sd.deleteStudent(id);
					System.out.println("Student deleted..!!!");
					break;
				case 5:
					// update the student
					System.out.println("Enter user id to update:");
					int updateUserId = Integer.parseInt(br.readLine());
					Student studentToUpdate = sd.getStudent(updateUserId);
					
					System.out.println("#####################################");
					if (studentToUpdate != null) {
						System.out.println("Enter new name:");
						String newName = br.readLine();
						System.out.println("**********************************");
						System.out.println("Enter new city:");
						String newCity = br.readLine();

						// Update the student details
						studentToUpdate.setStudentName(newName);
						studentToUpdate.setStudentCity(newCity);

						// Call the update method in the StudentDao
						sd.updateStudent(studentToUpdate);

						System.out.println("Update successful...!!");
					} else {
						System.out.println("Student not found with ID: " + updateUserId);
					}

					break;
				case 6:
					// exit
					go = false;
					break;

				}

			} catch (Exception e) {
				System.out.println("Invalid input try with another one !!!");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Thankyou for using my application");
		System.out.println("See you soon..!!");
	}
}
