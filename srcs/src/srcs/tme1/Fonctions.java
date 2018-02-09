package srcs.tme1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Fonctions {
	public static void clavierVersEcran() {
		InputStreamReader isr = new InputStreamReader(System.in);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
			
		Cat.cat(isr, osw);
	}
	
	public static void clavierVersFichier() {
		InputStreamReader isr = new InputStreamReader(System.in);
		OutputStreamWriter osw;
		try {
			osw = new FileWriter("fichier");
			Cat.cat(isr, osw);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("problme ouverture fichier");
		}
	}
	
	public static void clavierVersEcranCesar(int decalage){
		Reader isr = new InputStreamReader(System.in);
		Writer osw = new CesarWriter(new OutputStreamWriter(System.out), decalage);;
		Cat.cat(isr, osw);
	}
	
	public static void clavierVersEcranTee(){
		Reader isr = new InputStreamReader(System.in);
		Writer osw = new TeeWriter(new OutputStreamWriter(System.out), new OutputStreamWriter(System.err));;
		Cat.cat(isr, osw);
	}
}
