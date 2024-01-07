package com.spring.Jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.dao.StundetDao;
import com.springjdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("My program is started....");
        
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        
        // spring jdbc => JdbcTemplete
      //  ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/Jdbc/config.xml");
      //  JdbcTemplate jt=context.getBean("jdbctemplate",JdbcTemplate.class);
        
        //insert query
      //  String query ="insert into student(id,name,city) values(?,?,?)";
        
        //fire query
        
//        int result=jt.update(query,103,"Deepak","Delhi");
//        System.out.println("Number of row inserted.."+result);
        
        StundetDao st=  context.getBean("stundetDao",StundetDao.class);
        
        //insert
        Student s=new Student();
        s.setId(110);
        s.setName("Karan");
        s.setCity("Amritsar");
        
        int result= st.insert(s);
        System.out.println("Student added.."+result);
        
        //update
//        Student str=new Student();
//        str.setId(102);
//        str.setName("Gautam");
//        str.setCity("Harduaganj");
//        
//        int result = st.change(str);
//        System.out.println("Data changed.."+result);
        
        //delete
//        int delete = st.delete(104 );
//        System.out.println("Delete operaton successfully.."+delete);
        
//        Student s = st.getStudent(101);
//        System.out.println(s);
        
        List<Student> allst = st.getAllStudents();
        for(Student ss: allst) {
        	System.out.println(ss);
        }
        
    }
}
