package com.BankManagement;
import java.sql.*;
public class ConnectWithJdbc {
	
     Connection c;
     Statement s;

	 ConnectWithJdbc() {
    	 try
    	 {
    		 Class.forName("com.mysql.cj.jdbc.Driver");
    		 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/praveen","root","12345");
    		 s=c.createStatement();
    		 
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println("kya is mein error hai");
    		 System.out.println(e);
    	 }
     }
	
	}


