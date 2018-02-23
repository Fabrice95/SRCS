package srcs.tme2.v1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import srcs.tme1.CesarWriter;
import srcs.tme1.Fonctions;
import srcs.tme2.base.GlobalConstants;

public class Client {
	private static int decalage = -5;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Client v1");
		try {
			Socket c = null;
			
			InputStream is;
			OutputStream os;
			
			int i = 0;
			while (i < GlobalConstants.max*2) {
				while ( c == null) {
					try {
						c = new Socket("localhost", 8080);
					} catch (ConnectException e) {
						Thread.sleep(1000);
					}
				}
				if((i%2)==0) {
					os = c.getOutputStream();
					System.out.println("> Saisir message:");
					Fonctions.clavierVersDestination(new CesarWriter(new OutputStreamWriter(os), decalage));
				}else {
					is = c.getInputStream();
//					Fonctions.sourceVersEcran(new InputStreamReader(is));
					Fonctions.sourceVersEcran(new CesarReader(new InputStreamReader(is), decalage));
				}
				i++;
				c.close();
				c = null;
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
