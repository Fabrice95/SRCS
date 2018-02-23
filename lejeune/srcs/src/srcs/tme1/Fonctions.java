package srcs.tme1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Fonctions {
	public static void clavierVersEcran() {
		Reader isr = new InputStreamReader(System.in);
		Writer osw = new OutputStreamWriter(System.out);
			
		Cat.cat(isr, osw);
	}
	
	public static void clavierVersDestination(Writer destination) {
		Reader isr = new InputStreamReader(System.in);
		Cat.cat(isr, destination);
	}
	
	public static void sourceVersEcran(Reader source) {
		Writer osw = new OutputStreamWriter(System.out);
		Cat.cat(source, osw);
	}
	
	
	public static void clavierVersFichier() {
		Reader isr = new InputStreamReader(System.in);
		Writer osw;
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
		Writer osw = new TeeWriter(new OutputStreamWriter(System.out), new OutputStreamWriter(System.err));
		Cat.cat(isr, osw);
	}
	
//	En utilisant une seule fois la méthodecat, écrire un programme qui à partir de ce qui est saisi au
//	clavier produit une :
//	-version cryptée sur la sortie standard.
//	-version non cryptée sur la sortie erreur.
//	-version cryptée dans un chier
//	-version non cryptée dans un second chier
	
	public static void glob() throws IOException {
		Reader r = new InputStreamReader(System.in);
		
		OutputStreamWriter oswfw = new FileWriter("fichier");
		OutputStreamWriter oswfw2 = new FileWriter("fichier2");
		
		Writer sw1 = new CesarWriter(new TeeWriter( new OutputStreamWriter(System.out), oswfw), 1);
		Writer sw2 = new TeeWriter(new OutputStreamWriter(System.err), oswfw2);
		
		Writer w = new TeeWriter(sw1, sw2);
		
		Cat.cat(r, w);
	}
}
