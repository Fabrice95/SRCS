package srcs.tme5;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientMain {

	public static void main(String[] args) {
		
		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			
			Annuaire a = (Annuaire)registry.lookup("Annuaire");
			System.out.println("Entree A, son numero " + a.getNumber("A"));
			System.out.println("Entree B, son numero " + a.getNumber("B"));
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}

}
