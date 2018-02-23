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
	public void write(int c) throws IOException {
		super.write(c);
		super.flush();
		writer.write(c);
		writer.flush();
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		super.write(cbuf, off, len);
		//super.flush();
		writer.write(cbuf, off, len);
		//writer.flush();
	}

	@Override
	public void write(String str, int off, int len) throws IOException {
		super.write(str, off, len);
		//super.flush();
		writer.write(str, off, len);
		//writer.flush();
	}
	
	
}
