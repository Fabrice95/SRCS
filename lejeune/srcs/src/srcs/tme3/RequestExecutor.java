package srcs.tme3;

import java.net.Socket;

public abstract class RequestExecutor implements Runnable {
	
	private final Socket socket;
	
	public RequestExecutor(Socket socket) {
		this.socket = socket;
	}
	
	public Socket getSocket() {
		return socket;
	}
	
//	@Override
//	public abstract void run();
}
