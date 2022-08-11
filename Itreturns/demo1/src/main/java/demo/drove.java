package demo;

import java.io.*;

import jakarta.servlet.http.*;

public class drove extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int x = Integer.parseInt(req.getParameter("x"));
		int y = Integer.parseInt(req.getParameter("y"));
		int z = x+y;
		PrintWriter out = res.getWriter();
		out.println("sum:"+z);
		File f = new File("D:/j2ee/a.txt");
		f.createNewFile();
		FileOutputStream fout = new FileOutputStream(f);
		fout.write(("Sum:"+z).getBytes());
		fout.close();
	}
}
