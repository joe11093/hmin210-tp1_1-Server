package p1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.TimeUnit;

import Interfaces.Animal;
import Interfaces.CabinetVeterinaire;
import Interfaces.Species;

public class Server {

	public Server(){
		
	}
	
	public static void main(String args[]){
		try{
			
			//security manager
			if(System.getSecurityManager() == null){
				System.setProperty("java.security.policy", "./file.policy");
				System.setSecurityManager(new SecurityManager());
			}
			
			/*Species cat = new Species("cat");
			Animal  obj = new AnimalImpl("Toad", "Joseph", cat, "Street Cat");
			obj.getAnimalFile().setContent("voice le dossier");*/
			
			CabinetVeterinaire cabinet = new CabinetVeterinaireImpl();
			
			Registry registry = LocateRegistry.createRegistry(1099);
			if(registry==null)
				System.err.println("RMI Registry not found");
			else{
				registry.rebind("CabinetVeterinaire", cabinet);
				System.err.println("Server is ready\n");
				//Testing if species is passed by copy
				
			}
			
		}catch(Exception e){
			System.err.println(e.toString());
			e.printStackTrace();
		}
	}
}
