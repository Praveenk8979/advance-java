package CurdNew;
import java.sql.*;
public class RetrieveOp {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Tab_P", "root", "12345");
		
		String query="select *from result";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			
			int value1=rs.getInt("Id");
			String value2=rs.getString("Name");
			String value3=rs.getString("Email");
			String value4=rs.getString("Password");
			
			System.out.println("Id"+value1+ "Name"+value2+ " Email"+value3+" Password"+value4);
		}
	}

}
