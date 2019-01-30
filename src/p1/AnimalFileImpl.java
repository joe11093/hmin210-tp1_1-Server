package p1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Interfaces.AnimalFile;

public class AnimalFileImpl extends UnicastRemoteObject implements AnimalFile{

	private static final long serialVersionUID = 3925203313610631067L;
	
	//properties
	String content;
	
	protected AnimalFileImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected AnimalFileImpl(String c) throws RemoteException {
		super();
		this.content = c;
	}

	@Override
	public void setContent(String content) throws RemoteException {
		this.content = content;
		
	}

	@Override
	public String getContent() throws RemoteException {
		return this.content;
	}

}
