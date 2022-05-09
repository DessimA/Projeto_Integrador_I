package sistemaacademico.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author DessimA
 */
public abstract class Pessoa {
    protected @Getter @Setter String nome;
    protected @Getter @Setter String cpf;
    protected @Getter @Setter String matricula;
    protected @Getter @Setter String senha;
    protected @Getter @Setter Curso curso;
    protected ArrayList<Mensagem> inbox = new ArrayList<>();

    //CONSTRUTOR
    public Pessoa(String nome, String cpf, String matricula, Curso curso) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.curso = curso;
        
        this.senha = "1234";
    }
        
    //METODOS ESPECIAIS    
   
   
    public ArrayList<Mensagem> getInbox() {
        return inbox;
    }

    public void setInbox(Mensagem mensagem) {
    	inbox.add(mensagem);
    }

    //OUTROS METODOS
    public void mudarSenha(String novaSenha) {
    	this.senha = novaSenha;    	
    }
    
    //-- PARA OBJETOS QUE HERDAM DE PESSOA (ALUNO E PROFESSOR)
    public void enviarMensagem(Pessoa destinatario, String texto) {
    	Mensagem mensagem = new Mensagem(texto,this.getNome());
    	destinatario.setInbox(mensagem);
    }   
    //-- EXCLUSIVO PARA O ADMINISTRADOR (RECEBIMENTO DE MENSAGEM POR PARTE DELE)
    public void enviarMensagem(Administrador destinatario, String texto) {
    	Mensagem mensagem = new Mensagem(texto,this.getNome());
    	destinatario.setInbox(mensagem);
    } 
        

    
}
