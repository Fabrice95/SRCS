package srcs.tme5;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class AnnuaireImpl extends UnicastRemoteObject implements Annuaire {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, String> annuaire;
	
	public AnnuaireImpl() throws RemoteException {
		super();
		annuaire = new HashMap<>();
	}
	
	@Override
	public String getNumber(String name) throws RemoteException {
		return annuaire.get(name);
	}

	@Override
	public void addEntry(String name, String number) throws RemoteException {
		annuaire.put(name, number);
	}
	
}
