package com.sistema.DAO;

import java.util.List;

import com.sistema.ModelDAO.Aluno;


public interface AlunoDAO {

	public int create(Aluno aluno);
	
	public int update(Aluno aluno);
	
	public Aluno findById(Double id);
	
	public List<Aluno> findAll();
	
	
}
