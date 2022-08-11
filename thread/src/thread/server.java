package thread;

import java.io.DataInputStream;
import java.net.*;

public class server {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(6660);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String mssg = (String)dis.readUTF();
			System.out.println("Message: "+mssg);
			ss.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
