package sistemaacademico.model;

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

    // CONSTRUTOR
    public Pessoa(String nome, String cpf, String matricula, Curso curso) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.curso = curso;

        this.senha = "1234";
    }

    // METODOS ESPECIAIS

    // OUTROS METODOS
    public void mudarSenha(String novaSenha) {
        this.senha = novaSenha;
    }

}
