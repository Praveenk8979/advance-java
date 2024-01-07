package CurdNew;
import java.sql.*;
public class CreateTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int id=4;
		String name=" Yatendra";
		String email=" yatendra@gmail.com";
		String password=" yatendra@123";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Tab_P", "root", "12345");
		
		PreparedStatement pt=con.prepareStatement("insert into result values(?,?,?,?)");
		
		pt.setInt(1, id);;
		pt.setString(2, name);
		pt.setString(3, email);
		pt.setString(4, password);
		
		int i=pt.executeUpdate();
		if(i>0) {
			System.out.println("Successfully");
		}else {
			System.out.println("Fail");
		}
	}

}
