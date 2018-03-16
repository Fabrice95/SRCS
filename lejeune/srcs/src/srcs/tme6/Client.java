package srcs.tme6;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client extends Thread {
	private static final int N = 3;
	private SharedVariable<Integer> sharedVariableInteger;
	
	public Client(SharedVariable<Integer> sharedVariableInteger) {
		super();
		this.sharedVariableInteger = sharedVariableInteger;
	}


	public void run() {
		try {
			Integer i = sharedVariableInteger.verrouiller();
			i++;
			sharedVariableInteger.relacher(i);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
	
	
	public static void main(String[] args) {
		
		try {
			Registry registry = LocateRegistry.getRegistry("localhost");
			
			SharedVariable<Integer> sharedVar = (SharedVariable<Integer>) registry.lookup("sharedVariable");
			
			Integer var;
			try {
				var = sharedVar.verrouiller();
				System.out.println("Valeur initiale de la variable " + var);
				sharedVar.relacher(var);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			Thread t[] = new Thread[N];
			for (int i=0; i<N; i++) {
				t[i] = new Client(sharedVar);
				t[i].start();
			}

			for (int i=0; i<N; i++) {
				try {
					t[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				};
			}
			
			try {
				var = sharedVar.verrouiller();
				System.out.println("Valeur finale de la variable " + var);
				sharedVar.relacher(var);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}

}
