package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import file.IOFile;
import model.SinhVien;

public class FileImpl extends UnicastRemoteObject implements ISinhVien {
	private ArrayList<SinhVien> listSV;
	private IOFile ioFile;

	/**
	 * Contructor
	 * 
	 * @throws RemoteException
	 */
	public FileImpl() throws RemoteException {
		/**
		 * Ngay sau khi khoi tao thi phai load toan bo SinhVien trong file vao ArrayList
		 */
		this.ioFile = new IOFile("SinhVien.txt");
		listSV = ioFile.loadFile();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object action(int type, SinhVien sv) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			switch (type) {
			case 1: {// add
				/**
				 * method add return size of list
				 */
				int ma=0;
				if(listSV.isEmpty()) {
					ma = 0;
				}else {
					ma = listSV.get(listSV.size()-1).getMaSV();
				}
				sv.setMaSV(ma + 1);
				this.listSV.add(sv);

				// return this.listSV.get(listSV.size() - 1);
				// break;
			}
			case 2: {// view
				return this.listSV;
				 

			}
			case 3: {// edit
				for(SinhVien x: listSV) {
					if(x.getMaSV() == sv.getMaSV()) {
						x.setTenSV(sv.getTenSV());
						x.setEmail(sv.getEmail());
						return true;
					}
				}
				return false;
			}
			case 4: {// delete
				if(listSV.contains(sv)) {
					listSV.remove(sv);
					return true;
				}
				return false;
			}
			case 5: {// save
				return this.ioFile.saveFile(listSV);
			}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}

}
