package srcs.tme2.base;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	// private int port;
	//
	// public Serveur(int port) {
	//
	// }

	public static void main(String[] args) {
		try {
			// creation de la socket
			ServerSocket s = new ServerSocket(8080);
			
			// attentes de connexions
			Socket c1 = s.accept();
			Socket c2 = s.accept();
			Socket c3 = s.accept();

			
			InputStream is;
			// OutputStream os;

			// communication avec c1
			System.out.println("Mon Port:" + c1.getLocalPort());
			System.out.println("Port interlocuteur:" + c1.getPort());
			// code fonctionnel mais pas pour l'exo
			int ch;
			// os = c1.getOutputStream();
			// os.write(2);
			is = c1.getInputStream();
			ch = is.read();
			System.out.println(ch);
			c1.close();

			// communication avec c2
			System.out.println("Mon Port:" + c2.getLocalPort());
			System.out.println("Port interlocuteur:" + c2.getPort());
			// code fonctionnel mais pas pour l'exo
			// OutputStream os = c2.getOutputStream();
			// os.write(2);
			is = c2.getInputStream();
			ch = is.read();
			System.out.println(ch);
			c2.close();

			// communication avec c3
			System.out.println("Mon Port:" + c3.getLocalPort());
			System.out.println("Port interlocuteur:" + c3.getPort());
			// code fonctionnel mais pas pour l'exo
			// OutputStream os = c3.getOutputStream();
			// os.write(2);
			is = c3.getInputStream();
			ch = is.read();
			System.out.println(ch);
			c3.close();
			
//			// communication avec c2
//			System.out.println("Mon Port:" + c2.getLocalPort());
//			System.out.println("Port interlocuteur:" + c2.getPort());
//			is = c1.getInputStream();
//			Fonctions.sourceVersEcran(new InputStreamReader(is));
//			c2.close();

			s.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
