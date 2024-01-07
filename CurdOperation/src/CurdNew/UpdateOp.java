package CurdNew;
import java.sql.*;
public class UpdateOp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int id=1;
		String email=" praveenchauhan@gmail.com";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Tab_P", "root", "12345");
		PreparedStatement pt=con.prepareStatement("update result set Id=? Where Email=?");

		pt.setInt(1, id);
		pt.setString(2, email);
		
		int count=pt.executeUpdate();
		if(count>0) {
			System.out.println("Successfully");
		}else {
			System.out.println("Fail");
		}
		
	}

}
