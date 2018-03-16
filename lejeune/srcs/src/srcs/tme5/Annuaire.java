package srcs.tme5;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Annuaire extends Remote {
	public String getNumber(String name) throws RemoteException;
	public void addEntry(String name, String number) throws RemoteException;
}
