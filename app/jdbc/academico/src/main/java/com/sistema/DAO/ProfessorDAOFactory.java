package com.sistema.DAO;

public class ProfessorDAOFactory {
	
	public static ProfessorDAO createDAO() {
		return new ProfessorDAOImpl();
	}

}
