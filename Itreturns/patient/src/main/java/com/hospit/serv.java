package com.hospit;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class serv
 */
public class serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
	   boolean isconnected = false;
		while(isconnected==false) {
			isconnected = register.createConnection();
		}
		Connection conn = register.conn;
		PrintWriter out = res.getWriter();
		String del = req.getParameter("del");
		if(!del.isEmpty()) {
			int i = Integer.parseInt(req.getParameter("id"));
			try {
				Statement st = conn.createStatement();
				String q1 = "delete from pat where id='"+i+"'";
				st.executeQuery(q1);
				out.println("deleted");
			}catch(Exception e2) {
				System.out.println(e2);
			}

		}
		String name =req.getParameter("name");
		String date =req.getParameter("date");
		String cause =req.getParameter("cause");
		String doctor =req.getParameter("doctor");
		int id = Integer.parseInt(req.getParameter("id"));
		int age = Integer.parseInt(req.getParameter("age"));
		System.out.println(name+date+cause);
		try {
			System.out.println(id+name+date);
			Statement st = (Statement) conn.createStatement();
			String q = "insert into pat values('"+id+"','"+name+"','"+age+"','"+date+"','"+doctor+"','"+cause+"')";
			st.executeUpdate(q);
			out.println("Updated!!");
		}catch(Exception e1) {
			System.out.println(e1);
		}
   }

}
