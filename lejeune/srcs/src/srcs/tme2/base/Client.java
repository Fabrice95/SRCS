package srcs.tme2.base;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws InterruptedException {
		try {
			Socket c = null;
			
			
			// Etablissement de la connexion 
			while ( c == null) {
				try {
					c = new Socket("localhost", 8080);
				} catch (ConnectException e) {
					Thread.sleep(1000);
				}
			}
			
			// test infos
			System.out.println("Mon Port:"+c.getLocalPort());
			System.out.println("Port interlocuteur:"+c.getPort());
			
			
			// traitement
//			InputStream is;
			OutputStream os;
			
			os = c.getOutputStream();
			os.write(3);
//			is = c.getInputStream();
//			int ch = is.read();
//			System.out.println(ch);
			c.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
