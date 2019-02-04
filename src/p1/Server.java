package p1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
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
			
			//set codebase
			System.setProperty("java.rmi.server.codebase", "file:///C:/Users/josep/workspace/java/hmin210-tp1_1-Client/bin/" );
			//create array list to pass to the CabinetVeterinaireImpl Contructor
			ArrayList<Animal> l = new ArrayList<Animal>();
			l.add(new AnimalImpl("Toad", "Joseph", new Species("cat"), "Street Cat"));
			l.add(new AnimalImpl("Courage", "Leila", new Species("dog"), "Labrador"));
			l.add(new AnimalImpl("Luna", "Joseph", new Species("cat"), "Street Cat"));
			
			CabinetVeterinaire cabinet = new CabinetVeterinaireImpl(l);
			
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
