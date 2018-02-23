package srcs.tme2.v1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import srcs.tme1.CesarWriter;
import srcs.tme1.Fonctions;
import srcs.tme2.base.GlobalConstants;

public class Serveur {
	 private static int decalage = -5;

	public static void main(String[] args) {
		System.out.println("Server v1");
		try {
			ServerSocket s = new ServerSocket(8080);
			Socket c1;

			InputStream is;
			OutputStream os;
			
			int i = 0;
			while (i < GlobalConstants.max*2) {
				if((i%2)==0) {
					c1 = s.accept();
					is = c1.getInputStream();
//					Fonctions.sourceVersEcran(new CesarReader(new InputStreamReader(is), decalage));
					Fonctions.sourceVersEcran(new InputStreamReader(is));
					c1.close();
				}else {
					c1 = s.accept();
					os = c1.getOutputStream();
					System.out.println("> Saisir message:");
//					Fonctions.clavierVersDestination(new CesarWriter(new OutputStreamWriter(os), decalage));
					Fonctions.clavierVersDestination(new OutputStreamWriter(os));
					c1.close();
				}
				i++;
			}
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
