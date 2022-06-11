
package sistemaacademico.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class Professor extends Pessoa {
    private @Getter @Setter String areaAtuacao;
    private ArrayList<Turma> turmas;

    // CONSTRUTOR
    public Professor(String nome, String cpf, String matricula, Curso curso, String areaAtuacao) {
        super(nome, cpf, matricula, curso);

        this.areaAtuacao = areaAtuacao;
    }

    // GETTERS AND SETTERS

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }

    // METODOS

    @Override
    public String toString() {
        return getNome();
    }

}
