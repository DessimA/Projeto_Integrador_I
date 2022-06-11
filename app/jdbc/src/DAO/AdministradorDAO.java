package DAO;

import java.util.List;

import ModelDAO.Administrador;

public interface AdministradorDAO {

	public int create(Administrador adm);
	
	public int update(Administrador adm);
	
	public Administrador findById(Double id);
	
	public List<Administrador> findAll();
	
	
}
