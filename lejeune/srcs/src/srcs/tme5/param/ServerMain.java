package srcs.tme5.param;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {

	public static void main(String[] args) {
		try {
			Annuaire a = new AnnuaireImpl();
			a.addEntry(new Personne("A", "Aprenom", "0123456789", "adr1"));
			a.addEntry(new Personne("B", "Bprenom", "9876543210", "adr2"));
//			UnicastRemoteObject.exportObject(a, 4242);
			
			Registry registry = LocateRegistry.getRegistry("localhost");
			registry.rebind("Annuaire", a);
//			UnicastRemoteObject.unexportObject(a, true);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
//		catch (AlreadyBoundException e1) {
//			e1.printStackTrace();
//		}
	}

}
