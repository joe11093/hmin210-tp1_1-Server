package p1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Interfaces.Animal;
import Interfaces.CabinetVeterinaire;
import Interfaces.Species;

public class CabinetVeterinaireImpl extends UnicastRemoteObject implements CabinetVeterinaire {
	
	private static final long serialVersionUID = 1L;
	List<Animal> animals;
	
	//constructor without parameters
	protected CabinetVeterinaireImpl() throws RemoteException {
		super();
		this.animals = new ArrayList<Animal>();
	}
	
	//constructor that takes a list as a parameter
	protected CabinetVeterinaireImpl(List<Animal> list) throws RemoteException {
		super();
		this.animals = list;
	}

	@Override
	public Animal searchAnimal(String name) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(name);
		for(Animal a: this.animals){
			if(a.getName().equals(name))
				return a;
		}
		
		return null;
	}

	@Override
	public void addAnimal(String name, String owner, String species, String race) throws RemoteException {
		// TODO Auto-generated method stub
		Animal a = new AnimalImpl(name, owner, new Species(species), race);
		animals.add(a);	
	}


}
