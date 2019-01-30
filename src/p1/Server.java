package p1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.TimeUnit;

import Interfaces.Animal;
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
			
			Species cat = new Species("cat");
			Animal  obj = new AnimalImpl("Toad", "Joseph", cat, "Street Cat");
			obj.getAnimalFile().setContent("voice le dossier");
			Registry registry = LocateRegistry.createRegistry(1099);
			if(registry==null)
				System.err.println("RMI Registry not found");
			else{
				registry.rebind("Animal", obj);
				System.err.println("Server is ready");
				//Testing if species is passed by copy
				System.out.println(obj.printAnimal());
				System.out.println("WAITING");
				TimeUnit.SECONDS.sleep(10);
				System.out.println("DONE WAITING");
				System.out.println(obj.printAnimal());
			}
			
		}catch(Exception e){
			System.err.println(e.toString());
			e.printStackTrace();
		}
	}
}
