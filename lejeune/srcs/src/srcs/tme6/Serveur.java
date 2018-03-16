package srcs.tme6;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Serveur {

	public static void main(String[] args) {
		try {
			SharedVariable<Integer> sharedVar = new SharedVariableImpl<Integer>(0);
			System.out.println("La variable cree et initialise a : 0");
			UnicastRemoteObject.exportObject(sharedVar, 0);
			
			Registry registry = LocateRegistry.getRegistry("localhost");
			registry.rebind("sharedVariable", sharedVar);
			
//			UnicastRemoteObject.unexportObject(a, true);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
//		catch (AlreadyBoundException e1) {
//			e1.printStackTrace();
//		}
	}

}
