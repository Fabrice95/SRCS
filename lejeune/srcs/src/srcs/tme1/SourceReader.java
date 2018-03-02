package srcs.tme1;

import java.io.IOException;
import java.io.Reader;

public class SourceReader {
	Reader reader;
	
	public SourceReader(Reader reader) {
		this.reader = reader;
	}
	
	public String readLine() {
		int c;
		String line = "";
		try {
			while ((c=reader.read()) != '\n'){
				line = line + (char) c;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
}
