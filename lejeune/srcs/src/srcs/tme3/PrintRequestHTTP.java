package srcs.tme3;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import srcs.tme1.Fonctions;

public class PrintRequestHTTP extends RequestExecutor {

	public PrintRequestHTTP(Socket socket) {
		super(socket);
	}

	@Override
	public void run() {
		try {
			Fonctions.sourceVersEcran(new InputStreamReader(getSocket().getInputStream()));
		} catch (IOException e) {
			System.out.println("ERROR: getting Input sream reader");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new ServeurMultiThread(4343, PrintRequestHTTP.class).demarrer();
	}
}
