package thread;

import java.io.DataOutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",6660);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF("Message from client");
			dos.flush();
			dos.close();
			s.close();
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
