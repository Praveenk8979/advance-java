package com.curd;
import java.sql.*;
public class Delete {

	public static void main(String[] args)throws Exception {
		
		String email="akash@gmail.com";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/praveen", "root", "12345");
				
				PreparedStatement pt=con.prepareStatement("delete from register where Email_Id=?");
					pt.setString(1, email);
					int count=pt.executeUpdate();
					if(count>0) {
					System.out.println("Record deleted successfully");
					}else {
						System.out.println("Deletion failed");
					}
				}
			
		
	

}
