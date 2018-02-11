package srcs.tme1;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class TeeWriter extends FilterWriter {
	private Writer writer;
	
	public TeeWriter(Writer writer, Writer writer2) {
		super(writer);
		this.writer = writer2;
	}
	
	@Override
	public void write(int c){
		try {
			super.write(c);
			writer.write(c);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		try {
//			if(Character.isLetter(c)){
//				super.write(c);
//				writer.write(c);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		super.write(cbuf, off, len);
	}

	@Override
	public void write(String str, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		super.write(str, off, len);
	}
	
	
}
