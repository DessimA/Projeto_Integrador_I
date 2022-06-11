package academicoMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.AdministradorDAO;
import DAO.AdministradorDAOFactory;
import DAO.AlunoDAO;
import DAO.AlunoDAOFactory;
import DAO.DisciplinaDAO;
import DAO.DisciplinaDAOFactory;
import DAO.ProfessorDAO;
import DAO.ProfessorDAOFactory;
import ModelDAO.Administrador;
import ModelDAO.Aluno;
import ModelDAO.Disciplina;
import ModelDAO.Professor;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("============ MENU ============");
		System.out.println("Escolha a opcao");
		System.out.println("1 - Cadastrar Administrador");
		System.out.println("2 - Cadastar Professor");
		System.out.println("3 - Cadastrar Aluno");
		System.out.println("4 - Procurar Adm por ID");
		System.out.println("5 - Listar todos Adm");
		System.out.println("6 - Procurar Prof por ID");
		System.out.println("7 - Listar todos os Profs");
		System.out.println("8 - Procurar Aluno por ID");
		System.out.println("9 - Listar todos Alunos");
		System.out.println("10 - Cadastar Disciplina");
		System.out.println("11 - Listar Disciplina por ID");
		System.out.println("12 - Listar todas as Disciplinas");
		System.out.println("==============================");

		int o = s.nextInt();
		Administrador adm = new Administrador();
		AdministradorDAO admDAO = AdministradorDAOFactory.createDAO();
		List<Administrador> administrador = new ArrayList<>();

		Professor professor = new Professor();
		ProfessorDAO professorDAO = ProfessorDAOFactory.createDAO();
		List<Professor> Professor = new ArrayList<>();

		Aluno aluno = new Aluno();
		AlunoDAO alunoDAO = AlunoDAOFactory.createDAO();
		List<Aluno> Aluno = new ArrayList<>();

		Disciplina disciplina = new Disciplina();
		DisciplinaDAO disciplinaDAO = DisciplinaDAOFactory.createDAO();
		List<Disciplina> Disciplina = new ArrayList<>();

		// boolean aux = false;
		switch (o) {
			case 1:
				System.out.println("Cadastro de Administrador");
				System.out.println("=========================");
				System.out.println("Insira o seu nome: ");
				adm.setNome(s.next());
				System.out.println("Insira seu CPF: ");
				adm.setCpf(s.next());
				System.out.println("Insira sua Data de Nascimento: ");
				adm.setDataNascimento(s.next());
				/*
				 * System.out.println("Sua fun��o: ");
				 * 
				 * String funcao = s.next();
				 * if (funcao.toUpperCase().equals("PROFESSOR") ||
				 * funcao.toUpperCase().equals("PROFESSORA")
				 * || funcao.toUpperCase().substring(0, 2).equals("ADMINISTRADOR")) {
				 * aux = true;
				 * 
				 * }
				 * adm.setId_funcion(aux);
				 */
				admDAO.create(adm);
				System.out.println("Administrador cadastrado com sucesso!");

				s.close();
				break;
			case 2:
				System.out.println("Cadastro de Professor");
				System.out.println("=====================");
				System.out.println("Insira o seu nome: ");
				professor.setNome(s.next());
				System.out.println("Insira seu CPF: ");
				professor.setCpf(s.next());
				System.out.println("Insira sua Data de Nascimento: ");
				professor.setDataNascimento(s.next());
				professorDAO.create(professor);
				System.out.println("Professor cadastrado com sucesso!");

				s.close();
				break;

			case 3:
				System.out.println("Cadastro de Aluno");
				System.out.println("=================");
				System.out.println("Insira o seu nome: ");
				aluno.setNome(s.next());
				System.out.println("Insira seu CPF: ");
				aluno.setCpf(s.next());
				System.out.println("Insira sua Data de Nascimento: ");
				aluno.setDataNascimento(s.next());
				alunoDAO.create(aluno);
				System.out.println("Aluno cadastrado com sucesso!");

				s.close();
				break;

			case 4:
				System.out.println("Procurando Administrador por ID");
				System.out.println("===============================");
				System.out.println("Insira o ID a ser pesquisado:");
				Double id = s.nextDouble();
				adm = admDAO.findById(id);
				if (adm != null) {
					System.out.println("Objeto recuperado:");
					System.out.println(
							"Nome: " + adm.getNome() + " CPF: " + adm.getCpf() + "Data de Nascimento: "
									+ adm.getDataNascimento());

				} else {
					System.out.println("Objeto de id " + id + " nao encontrado");
				}

				s.close();
				break;

			case 5:
				System.out.println("Lista de Administradores");
				System.out.println("========================");
				System.out.println("Lista de adms");
				administrador = admDAO.findAll();
				for (Administrador adml : administrador) {
					System.out.println("Objeto recuperado:");
					System.out.println(
							"ID: " + adml.getId() + " Nome: " + adml.getNome() + " CPF: " + adml.getCpf()
									+ " Fun��o: " + adml.isId_funcion());
				}
				break;
			case 6:
				System.out.println("Procurando Professor por ID");
				System.out.println("===========================");
				System.out.println("Insira o ID a ser pesquisado:");
				Double idProfessor = s.nextDouble();
				professor = professorDAO.findById(idProfessor);
				if (professor != null) {
					System.out.println("Objeto recuperado:");
					System.out.println(
							"Nome: " + professor.getNome() + " CPF: " + professor.getCpf() + "Data de Nascimento: "
									+ professor.getDataNascimento());

				} else {
					System.out.println("Objeto de id " + idProfessor + " nao encontrado");
				}

				s.close();
				break;

			case 7:
				System.out.println("Lista de todos os Professores");
				System.out.println("=============================");
				System.out.println("Lista de professor");
				Professor = professorDAO.findAll();
				for (Professor professorl : Professor) {
					System.out.println("Objeto recuperado:");
					System.out.println(
							"ID: " + professorl.getId() + " Nome: " + professorl.getNome() + " CPF: "
									+ professorl.getCpf()
									+ " Data de Nascimento: " + professor.getDataNascimento());
				}
				break;
			case 8:
				System.out.println("Procurando Aluno por ID");
				System.out.println("=======================");
				System.out.println("Insira o ID a ser pesquisado:");
				Double idAluno = s.nextDouble();
				aluno = alunoDAO.findById(idAluno);
				if (aluno != null) {
					System.out.println("Objeto recuperado:");
					System.out.println(
							"Nome: " + aluno.getNome() + " CPF: " + aluno.getCpf()
									+ " Data de Nascimento: " + aluno.getDataNascimento());

				} else {
					System.out.println("Objeto de id " + idAluno + " nao encontrado");
				}

				s.close();
				break;
			case 9:
				System.out.println("Lista de todos os Alunos");
				System.out.println("========================");
				System.out.println("Lista de Alunos");
				Aluno = alunoDAO.findAll();
				for (Aluno alunol : Aluno) {
					System.out.println("Objeto recuperado:");
					System.out.println(
							"ID: " + alunol.getId() + " Nome: " + alunol.getNome() + " CPF: " + alunol.getCpf()
									+ " Data de Nsscimento: " + alunol.getDataNascimento());
				}
				break;
			case 10:
				System.out.println("Cadastro de Disciplina");
				System.out.println("=====================");
				System.out.println("Insira o nome da disciplina: ");
				disciplina.setNome(s.next());
				System.out.println("Insira o semestre da disciplina: ");
				disciplina.setIdSemestre(s.nextDouble());
				disciplinaDAO.create(disciplina);
				System.out.println("Disciplina cadastrada com sucesso!");

				s.close();
				break;
			case 11:
				System.out.println("Procurando Disciplina por ID");
				System.out.println("=======================");
				System.out.println("Insira o ID a ser pesquisado:");
				Double idDisciplina = s.nextDouble();
				disciplina = disciplinaDAO.findById(idDisciplina);
				if (disciplina != null) {
					System.out.println("Objeto recuperado:");
					System.out.println("Nome: " + disciplina.getNome());
				} else {
					System.out.println("Dsiciplina de id " + idDisciplina + " nao encontrado");
				}
				break;
			case 12:
				System.out.println("Lista de todas as Disciplina");
				System.out.println("========================");
				System.out.println("Lista de Disciplinas");
				Disciplina = disciplinaDAO.findAll();
				for (Disciplina disciplinal : Disciplina) {
					System.out.println("Disciplina recuperada:");
					System.out.println("ID: " + disciplinal.getId() + " Nome: " + disciplinal.getNome());
				}
				break;
			default:
				System.out.println();
				System.out.println();
				System.out.println("Saindo do programa...");
				break;
		}

	}

}
