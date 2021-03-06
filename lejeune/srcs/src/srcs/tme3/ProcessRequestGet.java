package srcs.tme3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
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
			String[] lineTable;
			boolean get = false;
			String resource = "/index.html";

			BufferedReader br = new BufferedReader(reader);
			writer = new FileWriter("tme3-exo3");
			try {
				while (((line = br.readLine()) != null) && (line.length() != 0)) {
					writer.write(line + "\n");
					writer.flush();
					lineTable = line.split(" ");
					if(lineTable[0].equals("GET")) {
						get = true;
						resource = lineTable[1];
						if(resource.equals("/"))
							resource = "/index.html";
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				writer.close();	
			}
			
//			DataOutputStream dos = new DataOutputStream(getSocket().getOutputStream());
			BufferedWriter dos = new BufferedWriter(new OutputStreamWriter(getSocket().getOutputStream()));
//			if (requestType.toUpperCase().equals("GET")) {
			if (get) {
				File file = new File(System.getProperty("user.dir")+resource);
				if(file.isFile()) {
					dos.write("HTTP/1.1 200 OK\r\n");
					dos.write("\r\n");
					br = new BufferedReader(new FileReader("."+resource));
					try {
						while ((line=br.readLine()) != null){
							dos.write(line);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					br.close();
				} else {
					dos.write("HTTP/1.1 404 Not Found\r\n");
					dos.write("\r\n");
				}
				
			} else {
				dos.write("400 Bad Request\r\n");
				dos.write("\r\n");
			}
			dos.flush();
			dos.close();
			getSocket().close();
		} catch (IOException e) {
			System.out.println("ERROR: IOError");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		new ServeurMultiThread(4343, ProcessRequestGet.class).demarrer();
	}
}
