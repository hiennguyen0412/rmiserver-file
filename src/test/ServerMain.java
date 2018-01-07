package test;

import java.rmi.RemoteException;

import controller.ServerControl;
import dao.ISinhVien;
import dao.FileImpl;

public class ServerMain {
	public static void main(String[] args) {
		ISinhVien dao;
		try {
			dao = new FileImpl();
			ServerControl control = new ServerControl(dao);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
