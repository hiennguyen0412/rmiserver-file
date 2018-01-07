package controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dao.ISinhVien;
import dao.FileImpl;

public class ServerControl { 
	private ISinhVien dao;
	
	public ServerControl(ISinhVien dao) {
		try {
			/**
			 * Create and reference to rmi registry
			 */
			Registry registry;
			registry = LocateRegistry.createRegistry(1234);
			
			this.dao = dao;
			/**
			 * Registry object
			 */
			registry.rebind("SinhVien", dao);
			System.out.println("SinhVienServer is created!");
		} catch(RemoteException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	
	
	
}
