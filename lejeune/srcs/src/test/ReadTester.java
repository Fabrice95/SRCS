package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ReadTester {
	public static void main(String[] args) {
		FileReader fr;
		Writer writer = new OutputStreamWriter(System.out);
		String line;
		try {
			fr = new FileReader("coucou.html");
			BufferedReader br = new BufferedReader(fr);
			
			try {
				while ((line = br.readLine()) != null ) {//(!().equals("\n\n")) && 
					
//					System.out.println(line);
				writer.write(line+"\n");
				writer.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("sorti");
	}
}
