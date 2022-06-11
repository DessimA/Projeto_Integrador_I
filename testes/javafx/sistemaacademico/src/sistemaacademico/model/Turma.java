
package sistemaacademico.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class Turma {
    private @Getter @Setter String codigo;
    private @Getter @Setter Curso curso;
    private @Getter @Setter Professor professor;
    private @Getter @Setter Disciplina disciplina;
    private ArrayList<Aluno> alunos;

    // CONSTRUTOR ===============
    public Turma(String codigo, Curso curso, Disciplina disciplina, Professor professor) {
        this.codigo = codigo;
        this.curso = curso;
        this.disciplina = disciplina;
        this.professor = professor;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    // METODOS

    public void mudarProfessor(Professor novoProfessor) {
        this.professor = novoProfessor;
    }

    @Override
    public String toString() {
        return getCodigo();
    }

}