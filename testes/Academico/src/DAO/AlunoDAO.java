package DAO;

import java.util.List;

import ModelDAO.Aluno;


public interface AlunoDAO {

	public int create(Aluno aluno);
	
	public int update(Aluno aluno);
	
	public Aluno findById(Double id);
	
	public List<Aluno> findAll();
	
	
}
