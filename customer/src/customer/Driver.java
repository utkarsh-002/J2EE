package customer;
import java.sql.*;
public class Driver {
	static Connection con = null;
	static boolean createConnection() {
		try {
			String url="jdbc:mysql://localhost:3306/db";
			String username = "root";
			String pass= "root@123";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,pass);
			System.out.println("Connection Established");
			return true;
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	public static void main(String[] args) {
		boolean isconnected = false;
		while(isconnected==false) {
			isconnected= createConnection();
		}
		MyFrame rame = new MyFrame(con);
	}

}
