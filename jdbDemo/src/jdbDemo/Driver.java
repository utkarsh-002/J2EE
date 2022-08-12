package jdbDemo;
import java.sql.*;

public class Driver {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/db";
		String uname="root";
		String pass="root@123";
		String query="select username from student where userid=123";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String na = rs.getString("username");
		System.out.println(na);
		st.close();
		con.close();

	}

}
