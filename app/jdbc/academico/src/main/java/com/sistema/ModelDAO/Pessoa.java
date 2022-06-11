package com.sistema.ModelDAO;


public class Pessoa {
	
	protected Double id;
	protected String nome;
	protected String dataNascimento;
    protected String cpf;
    
    
    public Double getId() {
		return id;
	}
	public void setId(Double id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	 public String getDataNascimento() {
			return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
			this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	
    
}
