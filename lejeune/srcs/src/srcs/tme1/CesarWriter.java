package srcs.tme1;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class CesarWriter extends FilterWriter {
	private int decalage;
	
	public CesarWriter(Writer writer, int decalage) {
		super(writer);
		this.decalage = (decalage < 0)? 26 + (decalage%26) : decalage%26;
	}
	
	@Override
	public void write(int c){
		try {
			if(Character.isLetter(c)){
				int a;
				a = (Character.isUpperCase(c))?'A':'a';
				
				//deuxieme methode
				 c = ((c - a + decalage)%26)+a;
			}
			super.write(c);
			super.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
