package srcs.tme2.v1;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CesarReader extends FilterReader {
	private int decalage;

	public CesarReader(Reader reader, int decalage) {
		super(reader);
		this.decalage = decalage * (-1);
		this.decalage = (this.decalage < 0)? 26 + (this.decalage%26) : this.decalage%26;
	}

	@Override
	public int read() {
		int c = -1;
		try {
			int a;
			c = super.read();
			if(Character.isLetter(c)){
				a = (Character.isUpperCase(c))?'A':'a';
				
				//deuxieme methode
				c = ((c - a + decalage)%26)+a;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return c;
	}
}
