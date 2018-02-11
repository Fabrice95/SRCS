package srcs.tme1;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class CesarWriter extends FilterWriter {
	private int decalage;
	
	public CesarWriter(Writer writer, int decalage) {
		super(writer);
		this.decalage = decalage; 
	}
	
	@Override
	public void write(int c){
		try {
			if(Character.isLetter(c)){
				int a,z;
				a = (Character.isUpperCase(c))?'A':'a';
				
				//premiere methode
				z = (Character.isUpperCase(c))?'Z':'z';
				
				if(c+decalage > z)
					c = a + ((c + decalage) - z - 1 );
				else
					c+=decalage;
				
				//deuxieme methode
				c = ((c - a + decalage)%26)+a;
				super.write(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
