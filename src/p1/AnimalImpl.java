package p1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Interfaces.Animal;
import Interfaces.AnimalFile;
import Interfaces.Species;

public class AnimalImpl extends UnicastRemoteObject implements Animal {
	
	private static final long serialVersionUID = 1L;
	
	//properties
	private String name;
	private String owner;
	private Species species;
	private String race;
	private AnimalFile file;
	
	//Constructor
	protected AnimalImpl(String name, String owner, Species species, String race) throws RemoteException {
		super();
		this.name = name;
		this.owner = owner;
		this.species = species;
		this.race = race;
		this.file = new AnimalFileImpl();
	}
	
	public AnimalImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	//setters and getters
	@Override
	public String getName() throws RemoteException {
		return this.name;
	}

	@Override
	public void setName(String name) throws RemoteException {
		this.name = name;
	}

	@Override
	public String getOwner() throws RemoteException {
		return this.owner;
	}

	@Override
	public void setOwner(String owner) throws RemoteException {
		this.owner = owner;
	}

	@Override
	public Species getSpecies() throws RemoteException {
		return this.species;
	}

	@Override
	public void setSpecies(Species species) throws RemoteException {
		this.species = species;
	}

	@Override
	public String getRace() throws RemoteException {
		return this.race;
	}

	@Override
	public void setRace(String race) throws RemoteException {
		this.race = race;
	}

	@Override
	public String printAnimal() throws RemoteException {
		return "AnimalImpl [name: " + name + ", owner: " + owner + ", species: "
				+ species + ", race: " + race + "]";
	}

	@Override
	public AnimalFile getAnimalFile() throws RemoteException {
		return this.file;
	}
	
	
	
	

}
