package srcs.tme6;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SharedVariable<T> extends Remote{
	public T verrouiller() throws InterruptedException, RemoteException;
	public void relacher(T variable) throws RemoteException;
}