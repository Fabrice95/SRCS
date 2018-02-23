package srcs.tme2.test;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import srcs.tme1.Cat;
import srcs.tme2.v1.CesarReader;

public class Testeur {
	public static void main(String[] args) {
		Reader reader = new InputStreamReader(System.in);
		Writer writer = new OutputStreamWriter(System.out);
		Cat.cat(new CesarReader(reader, 1), writer);
	}
}
