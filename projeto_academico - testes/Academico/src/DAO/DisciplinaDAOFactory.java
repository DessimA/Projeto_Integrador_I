package DAO;

public class DisciplinaDAOFactory {
	
	public static DisciplinaDAO createDAO() {
		return new DisciplinaDAOImpl();
	}

}
