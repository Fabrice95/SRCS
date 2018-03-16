package srcs.tme5;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {

	public static void main(String[] args) {
		try {
			Annuaire a = new AnnuaireImpl();
			a.addEntry("A", "0123456789");
			a.addEntry("B", "9876543210");
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
