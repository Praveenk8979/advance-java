package com.curd;

import java.sql.*;

public class CreateTable {

	public static void main(String[] args) throws Exception {
		
		int id=4;
		String name="Akash";
		String email="akash@gmail.com";
		String password="akash@123";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/praveen", "root", "12345");

//		PreparedStatement pt = con
//				.prepareStatement("insert into register values('"+id+"','"+name+"','"+email+"','"+password+"')");
		PreparedStatement pt = con
				.prepareStatement("insert into register values(?,?,?,?)");
		pt.setInt(1, id);
		pt.setString(2, name);
		pt.setString(3, email);
		pt.setString(4, password);
		int i = pt.executeUpdate();
		if (i > 0) {
			System.out.println("Record inserted successfully");
		} else {
			System.out.println("Fail");
		}

	}

}
