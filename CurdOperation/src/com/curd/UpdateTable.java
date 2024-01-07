package com.curd;
import java.sql.*;
public class UpdateTable {

	public static void main(String[] args) throws Exception {
		
		int id=3;
		String email="deepak@gmail.com";
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/praveen","root","12345");
				 
		            
				PreparedStatement pt=con.prepareStatement("update register set Id=? where Email_Id=?");

				pt.setInt(1, id);
				pt.setString(2, email);
				int count=pt.executeUpdate();
						
					if(count>0) {
				 System.out.println("Record Update Successfully");
					}else {
						System.out.println("Updation failed");
					}
					
				}
}
