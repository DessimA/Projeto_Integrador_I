package com.sistema.DAO;

import java.util.List;

import com.sistema.ModelDAO.Disciplina;



public interface DisciplinaDAO {

	public int create(Disciplina disciplina);
	
	public Disciplina findById(Double id);
	
	public List<Disciplina> findAll();
	
	
}
