package srcs.tme3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import srcs.tme1.Fonctions;
import srcs.tme2.base.GlobalConstants;

public class ClientPut {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Client Put");
		try {
			Socket c = null;
			
			InputStream is;
			OutputStream os;
			
			int i = 0;
			while (i < GlobalConstants.max*2) {
				try {
						c = new Socket("localhost", 4343);
						os = c.getOutputStream();
						Writer w = new OutputStreamWriter(os);
						w.write("PUT /data HTTP/1.1\r\n");
						w.write("\r\n");
						w.write("<html>\r\n");
						w.write("<body>\r\n");
						w.write("<p>Hello World!</p>\r\n");
						w.write("</body>\r\n");
						w.write("</html>\r\n");
						
						is = c.getInputStream();
						Reader r = new InputStreamReader(is);
						Fonctions.sourceVersEcran(r);
						
						c.close();
				} catch (ConnectException e) {
					Thread.sleep(1000);
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
