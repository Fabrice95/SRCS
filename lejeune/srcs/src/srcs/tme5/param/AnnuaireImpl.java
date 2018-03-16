package srcs.tme5.param;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class AnnuaireImpl extends UnicastRemoteObject implements Annuaire {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Personne> annuaire;
	
	public AnnuaireImpl() throws RemoteException {
		super();
		annuaire = new HashMap<>();
	}
	
	@Override
	public Personne getPersonne(String name) throws RemoteException {
		return annuaire.get(name);
	}

	@Override
	public void addEntry(Personne personne) throws RemoteException {
		annuaire.put(personne.getNom(), personne);
	}
	
}
