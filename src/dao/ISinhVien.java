package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import model.SinhVien;

public interface ISinhVien extends Remote{
	public Object action(int type, SinhVien sv) throws RemoteException;
}
