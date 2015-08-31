package in.bonu.java.networking.mylearn;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 
 * Telnet simulation using java or Socket programming helloworld
 * 
 * @author janardhanbonu
 *
 */
public class Telnet {
	public static void main(String[] args) {
	
		String hostName = "time.nist.gov";
		
		Socket socket = null;
		
		try {
			socket = new Socket(hostName, 13);
			InputStream in = socket.getInputStream();
			StringBuilder time = new StringBuilder();
			InputStreamReader reader = new InputStreamReader(in, "ASCII");
			for (int c = reader.read(); c!=  -1; c=reader.read()) {
				time.append((char)c);
			}
			System.out.println(time);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
