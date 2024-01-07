package com.curd;

import java.sql.*;

public class Retrieve {

	public static void main(String[] args)throws Exception {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/praveen", "root", "12345");
				String selectQuery = "select Id,Name from register";
				Statement st = con.createStatement(); 
				ResultSet rs = st.executeQuery(selectQuery);
					while (rs.next()) {
						int value1 = rs.getInt(1);
						String value2 = rs.getString("Name");
						System.out.println("Value1 :" + value1 +  "Value2 :" + value2);
					}

				}


	}


