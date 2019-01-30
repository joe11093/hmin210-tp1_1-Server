package p1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Interfaces.Animal;
import Interfaces.CabinetVeterinaire;

public class CabinetVeterinaireImpl extends UnicastRemoteObject implements CabinetVeterinaire {
	
	private static final long serialVersionUID = 1L;
	List<Animal> animals;
	
	protected CabinetVeterinaireImpl() throws RemoteException {
		super();
		this.animals = new ArrayList<Animal>();
	}

	@Override
	public Animal searchAnimal(String name) throws RemoteException {
		// TODO Auto-generated method stub
		for(Animal a: this.animals){
			if(a.getName() == name)
				return a;
		}
		return null;
	}

}
