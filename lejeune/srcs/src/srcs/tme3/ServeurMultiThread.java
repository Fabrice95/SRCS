package srcs.tme3;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurMultiThread {
	private final int port;
	private final Class<? extends RequestExecutor> executor;
	
	public ServeurMultiThread(int port, Class<? extends RequestExecutor> executor) {
		this.port = port;
		this.executor = executor;
	}
	
	public void demarrer() {
		
		ServerSocket s;
		Socket c;
		RequestExecutor re;
		try {
			s = new ServerSocket(port);
			while(true) {
				try {
					c = s.accept();
					re = (RequestExecutor) executor.getConstructor(Socket.class).newInstance(c);
					new Thread(re).start();
				} catch (IOException e) {
					System.out.println("ERROR: Waiting for a connection");
					e.printStackTrace();
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					System.out.println("ERROR: instanciation of RequestExecutor");
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			System.out.println("ERROR: creation of ServerSocket");
			e.printStackTrace();
		}
	}
}
