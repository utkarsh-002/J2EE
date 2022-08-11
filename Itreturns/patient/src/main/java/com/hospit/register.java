package com.hospit;

import java.sql.*;

public class register {
	static Connection conn = null;
	static boolean createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			String url = "jdbc:mysql://localhost:3306/db";
			String name = "root";
			String pass = "root@123";
			conn = DriverManager.getConnection(url,name,pass);
			System.out.println("Connection Established");
			return true;
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
}
