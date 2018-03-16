package srcs.tme6;

import java.rmi.RemoteException;

public class SharedVariableImpl<T> implements SharedVariable<T> {
	private T variable;
	private boolean occupe;
	
	public SharedVariableImpl(T variable) {
		super();
		this.variable = variable;
		occupe = false;
	}

	@Override
	public synchronized T verrouiller() throws InterruptedException, RemoteException {
		while (occupe) {
			this.wait();
		}
		occupe = true;
		return variable;
	}

	@Override
	public synchronized void relacher(T variable) throws RemoteException {
		this.variable = variable;
		this.notifyAll();
		occupe = false;
	}
}
