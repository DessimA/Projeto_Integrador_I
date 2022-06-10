package DAO;

import java.util.List;

import ModelDAO.Professor;


public interface ProfessorDAO {

	public int create(Professor professor);
	
	public int update(Professor professor);
	
	public Professor findById(Double id);
	
	public List<Professor> findAll();
	
	
}
