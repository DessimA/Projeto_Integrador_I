
package sistemaacademico.model;

import lombok.Getter;
import lombok.Setter;

public class Disciplina {
    private @Getter @Setter String nome;
    private @Getter @Setter Curso curso;

    // CONSTRUTOR ===============
    public Disciplina(String nome, Curso curso) {
        this.nome = nome;
        this.curso = curso;
    }

    // GETTERS E SETTERS ===============

    @Override
    public String toString() {
        return getNome();
    }

}
