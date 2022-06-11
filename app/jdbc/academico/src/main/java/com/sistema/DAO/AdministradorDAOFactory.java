package com.sistema.DAO;

public class AdministradorDAOFactory {
	
	public static AdministradorDAO createDAO() {
		return new AdministradorDAOImpl();
	}

}
