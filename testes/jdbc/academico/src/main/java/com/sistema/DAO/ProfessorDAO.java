package com.sistema.DAO;

import java.util.List;

import com.sistema.ModelDAO.Professor;


public interface ProfessorDAO {

	public int create(Professor professor);
	
	public int update(Professor professor);
	
	public Professor findById(Double id);
	
	public List<Professor> findAll();
	
	
}
