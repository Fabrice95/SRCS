package srcs.tme5.param;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Annuaire extends Remote {
	public Personne getPersonne(String name) throws RemoteException;
	public void addEntry(Personne personne) throws RemoteException;
}
