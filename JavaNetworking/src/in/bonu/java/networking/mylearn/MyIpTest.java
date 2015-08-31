package in.bonu.java.networking.mylearn;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyIpTest {

	public static void main(String[] args) {
		InetAddress address = null;
		try {
			address = InetAddress.getLocalHost();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(address);
		System.out.println(address.getHostName());
		System.out.println(address.getCanonicalHostName());
		System.out.println(address.getAddress());
		System.out.println(address.getHostAddress());
		
		System.out.println(address.isLinkLocalAddress());
		System.out.println(address.isAnyLocalAddress());
		
		InetAddress itebooks = null;
		try {
			itebooks = InetAddress.getByName("www.it-ebooks.info");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(itebooks);
	}
}
