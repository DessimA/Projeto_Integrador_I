package com.sistema.DAO;

public class AlunoDAOFactory {
	
	public static AlunoDAO createDAO() {
		return new AlunoDAOImpl();
	}

}
