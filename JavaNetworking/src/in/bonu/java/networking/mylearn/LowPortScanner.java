package in.bonu.java.networking.mylearn;

import java.io.IOException;
import java.net.Socket;

public class LowPortScanner {
	public static void main(String[] args) {
		String host = args.length > 0 ? args[0] : "localhost";
		
		for (int i = 8000; i < 9000; i++) {
				try {
				
					Socket socket = new Socket(host,i);
					System.out.println("There is server on port"+i+ "of localhost");
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
				}
				

		}
	}
}
