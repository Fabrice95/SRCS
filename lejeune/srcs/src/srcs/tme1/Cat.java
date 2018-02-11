package srcs.tme1;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Cat {

	public static void cat(Reader reader, Writer writer) {
		int c;
		try {
			while ((c=reader.read()) != -1){
				writer.write(c);
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
