package com.retur;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ITReturns extends HttpServlet{
	protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String name = req.getParameter("name");
		String gender= req.getParameter("gender");
		String salary = req.getParameter("sal");
		String tax = req.getParameter("tax");
		PrintWriter out = res.getWriter();
		File f = new File("D:/javalab/Itreturns/24.txt");
		f.createNewFile();
		FileOutputStream fout = new FileOutputStream(f);
		out.println(""+name+gender+salary+tax);
		fout.write(("hello"+name+gender+salary+tax).getBytes());
		fout.close();
		}
}
