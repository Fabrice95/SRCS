package srcs.tme3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class ProcessRequestGet extends RequestExecutor {

	public ProcessRequestGet(Socket socket) {
		super(socket);
	}

	@Override
	public void run() {
		Reader reader;
		Writer writer;

		try {
			reader = new InputStreamReader(new DataInputStream(getSocket().getInputStream()));
//			int c;
			String line;
			boolean get = false;

			BufferedReader br = new BufferedReader(reader);
			writer = new FileWriter("tme3-exo3");
			try {
				while (((line = br.readLine()) != null) && (line.length() != 0)) {
					writer.write(line + "\n");
					writer.flush();
					if(line.contains("GET"))
						get = true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
//				br.close();
				writer.close();	
			}

//			reader = new FileReader("tme3-exo3");
//			int i = 0;
//			String requestType = "";
//			while (i < 3) {
//				c = reader.read();
//				requestType = requestType + (char) c;
//				i++;
//			}
//			reader.close();
			
			System.out.println("test");
			
//			DataOutputStream dos = new DataOutputStream(getSocket().getOutputStream());
			BufferedWriter dos = new BufferedWriter(new OutputStreamWriter(getSocket().getOutputStream()));
//			if (requestType.toUpperCase().equals("GET")) {
			if (get) {
				System.out.println("Good Request");
				dos.write("HTTP/1.1 200 OK\r\n");
				dos.write("Content Length: 82\r\n");
				dos.write("\r\n");
				//dos.flush();
				reader = new FileReader("coucou.html");
				br = new BufferedReader(reader);
				try {
					while ((line=br.readLine()) != null){
						dos.write(line);
					}
					//dos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				reader.close();
			} else {
				System.out.println("400 Bad Request");
				dos.write("400 Bad Request");
				dos.flush();
			}
			dos.close();
			getSocket().close();
		} catch (IOException e) {
			System.out.println("ERROR: IOError l.87");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		new ServeurMultiThread(4343, ProcessRequestGet.class).demarrer();
	}
}
