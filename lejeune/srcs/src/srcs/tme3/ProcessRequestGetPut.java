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

import srcs.tme1.Fonctions;

public class ProcessRequestGetPut extends RequestExecutor {
	
	
	private enum RequestType {GET, PUT, OTHER};
	
	public ProcessRequestGetPut(Socket socket) {
		super(socket);
	}

	@Override
	public void run() {
		System.out.println("demarrage");
		Reader reader;
		Writer writer;

		try {
			reader = new InputStreamReader(new DataInputStream(getSocket().getInputStream()));

			String line;
			String[] lineTable;
			boolean content = false;
			
			RequestType method = RequestType.OTHER;
			String resource = "/index.html";
			File file;

			BufferedReader br = new BufferedReader(reader);
			writer = new FileWriter("tme3-exo3");
			try {
				while (((line = br.readLine()) != null) && (line.length() != 0)) {
					if(line.equals("\r\n")) {
						content = true;
					}
					if (content) {
						writer.write(line + "\n");
						writer.flush();
					}
					lineTable = line.split(" ");
					switch(lineTable[0]) {
					case "GET":
						method = RequestType.GET;
						resource = lineTable[1];
						if(resource.equals("/"))
							resource = "/index.html";
						break;
					case "PUT":
						method = RequestType.PUT;
						resource = lineTable[1];
						if(resource.equals("/"))
							resource = "/ajout.txt";
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				writer.close();	
			}
			

			BufferedWriter dos = new BufferedWriter(new OutputStreamWriter(getSocket().getOutputStream()));
			switch (method) {
			case GET:
				file = new File(System.getProperty("user.dir")+resource);
				
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
				
				break;
			case PUT:
				file = new File(System.getProperty("user.dir")+resource);
				if(!file.exists()) {
					file.createNewFile();
					dos.write("HTTP/1.1 201 Created\r\n");
					dos.write("\r\n");
				}else {
					Reader r = new FileReader("tme3-exo3");
					Writer w = new FileWriter(file);
					Fonctions.sourceVersDestination(r, w);
					dos.write("HTTP/1.1 200 OK\r\n");
					dos.write("\r\n");
					r.close();
				}
				break;
			default:
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
