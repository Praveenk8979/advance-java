package CurdNew;
import java.sql.*;
public class DeleteOp {

	public static void main(String[] args) throws Exception {
		String email=" yatendra@gmail.com";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Tab_P", "root", "12345");
		
		PreparedStatement pt=con.prepareStatement("delete from result where Email=? ");
		
		pt.setString(1, email);
		
		int count=pt.executeUpdate();
		
		if(count>0) {
			System.out.println("Successfully");
		}else {
			System.out.println("Fail");
		}
		
		}

}
