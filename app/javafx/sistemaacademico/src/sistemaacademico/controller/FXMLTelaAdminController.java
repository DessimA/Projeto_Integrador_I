package sistemaacademico.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import sistemaacademico.Main;
import sistemaacademico.model.Aluno;
import sistemaacademico.model.Administrador;
import sistemaacademico.model.Curso;
import sistemaacademico.model.Disciplina;
import sistemaacademico.model.Pessoa;
import sistemaacademico.model.Professor;
import sistemaacademico.model.Turma;

public class FXMLTelaAdminController implements Initializable {

    @FXML
    private ImageView imgvUser;

    @FXML
    private Label lblmatricula;

    @FXML
    private Pane paneRegistro;

    @FXML
    private JFXRadioButton rbtnAluno;

    @FXML
    private ToggleGroup registros;

    @FXML
    private JFXRadioButton rbtnProfessor;

    @FXML
    private GridPane gridAluno;

    @FXML
    private JFXTextField txtNomeAluno;

    @FXML
    private JFXTextField txtCPFAluno;

    @FXML
    private JFXTextField txtMatriculaAluno;

    @FXML
    private JFXButton btnRegistrarAluno;

    @FXML
    private JFXComboBox<Curso> cboxCursoAluno;

    @FXML
    private JFXComboBox<Turma> cboxTurma;

    @FXML
    private GridPane gridProfessor;

    @FXML
    private JFXTextField txtNomeProfessor;

    @FXML
    private JFXTextField txtCPFProfessor;

    @FXML
    private JFXTextField txtAreaProfessor;

    @FXML
    private JFXTextField txtMatriculaProfessor;

    @FXML
    private JFXButton btnRegistrarProfessor;

    @FXML
    private JFXComboBox<Curso> cboxCursoProfessor;

    @FXML
    private Pane paneCriacao;

    @FXML
    private JFXRadioButton rbtnDisciplina;
    
    @FXML
    private JFXRadioButton rbtnAlunosListar;

    @FXML
    private ToggleGroup criacao;

    @FXML
    private JFXRadioButton rbtnTurma;

    @FXML
    private JFXRadioButton rbtnCurso;

    @FXML
    private GridPane gridCurso;

    @FXML
    private JFXTextField txtNomeCurso;

    @FXML
    private JFXButton btnCriarCurso;

    @FXML
    private GridPane gridTurma;

    @FXML
    private JFXTextField txtNumTurma;

    @FXML
    private JFXButton btnCriarTurma;

    @FXML
    private JFXComboBox<Curso> cboxCurso;

    @FXML
    private JFXComboBox<Disciplina> cboxDisciplina;

    @FXML
    private JFXComboBox<Professor> cboxProfessor;

    @FXML
    private GridPane gridDisciplina;

    @FXML
    private JFXTextField txtNomeDisciplina;

    @FXML
    private JFXButton btnCriarDisciplina;

    @FXML
    private JFXComboBox<Curso> cboxCursoDisciplina;

    @FXML
    private Pane paneListar;

    @FXML
    private ToggleGroup listagem;

    @FXML
    private GridPane gridListaAlunos;

    @FXML
    private Label contadorAlunos;

    @FXML
    private JFXListView<Aluno> lvAlunos;

    @FXML
    private GridPane gridListaProfessores;

    @FXML
    private Label contadorProfessores;

    @FXML
    private JFXListView<Professor> lvProfessores;

    @FXML
    private GridPane gridListaCursos;

    @FXML
    private Label contadorCursos;

    @FXML
    private JFXListView<Curso> lvCursos;

    @FXML
    private GridPane gridListaTurmas;

    @FXML
    private Label contadorTurmas;

    @FXML
    private JFXListView<Turma> lvTurmas;

    @FXML
    private GridPane gridListaDisciplinas;

    @FXML
    private Label contadorDisciplinas;

    @FXML
    private JFXListView<Disciplina> lvDisciplinas;

    @FXML
    private Pane paneEditar;

    @FXML
    private JFXComboBox<Turma> cboxTurmaEditar;

    @FXML
    private JFXComboBox<Professor> cboxProfessorEditar;      
 
    
    @FXML
    private Label lblSaudacao;

    @FXML
    private ImageView imvSaudacao;    
     
    //INSTACIANDO ADMINISTRADOR
    Administrador administrador = Main.getInstance().administrador();
    int contIbox = 0;
    
    //ALERTAS --> SUBSTITUIR DEPOIS PELAS EXCEPTIONS!!!!
    Alert alert = new Alert(Alert.AlertType.ERROR);
    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
    
    public void erroCampo(){
       alert.setTitle("ERRO");
       alert.setHeaderText("H?? Campos vazios");
       alert.setContentText("Tente Novamente");
       alert.show();
    }  
    public void erroJaExiste(){
       alert.setTitle("ERRO");
       alert.setHeaderText("J?? existe esse cadastro!");
       alert.setContentText("Tente Novamente");
       alert.show();
    }  
    public void registroRealizado(String nome, String matricula){
       alert2.setTitle("REGISTRO");
       alert2.setHeaderText("REGISTRADO!");
       alert2.setContentText("NOME = "+nome+"\n\nMATRICULA = "+matricula+"\n\nSENHA = 1234");
       
       alert2.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
       alert2.show();
    }
    public void cadastroEfetuado(String item){
       alert2.setTitle("CRIADO");
       alert2.setHeaderText(null);
       alert2.setContentText("CRIADO COM SUCESSO!\n"+"??? "+item);
      
       alert2.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
       alert2.show();
    }
    public void removido(String item){
       alert2.setTitle("REMOVIDO");
       alert2.setHeaderText(null);
       alert2.setContentText(item+" foi removido");
       alert2.show();
    }
    public void atualizado(String professor, String turma){
       alert2.setTitle("ATUALIZADO");
       alert2.setHeaderText("ATUALIZADO COM SUCESSO!");
       alert2.setContentText(professor+" foi definido para "+turma);
       
       alert2.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
       alert2.show();
    }
   
        
    public void verItemListaAlunoProfessor(String curso, String nome, String matricula){
       alert2.setTitle("VER");
       alert2.setHeaderText(null);
       alert2.setContentText("Curso = "+curso+"\n\nNome = "+nome+"\n\nMatricula = "+matricula);
       
       alert2.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
       alert2.show();
    }  
    public void verItemListaTurma(String codigo, String professor){
       alert2.setTitle("VER");
       alert2.setHeaderText(null);
       alert2.setContentText("Nome/Codigo = "+codigo+"\nProfessor = "+professor);
       
       alert2.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
       alert2.show();
    }  
    public void verItemListaDisciplina(String nome, Curso curso){
       alert2.setTitle("VER");
       alert2.setHeaderText(null);
       alert2.setContentText("Nome = "+nome+"\nCurso = "+curso);
       
       alert2.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
       alert2.show();
    }  
    public void verItemListaCurso(String nome){
       alert2.setTitle("VER");
       alert2.setHeaderText(null);
       alert2.setContentText("Nome = "+nome);
       
       alert2.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
       alert2.show();
    }  
    
    //OBSERVABLELISTS
    private ObservableList<Curso> obsCursos;
    private ObservableList<Turma> obsTurmas;
    private ObservableList<Disciplina> obsDisciplinas;
    private ObservableList<Professor> obsProfessores;
    private ObservableList<Pessoa> obsPessoa;
    
    //LISTAS
    private ObservableList<Aluno> obsAlunoLista;
    private ObservableList<Professor> obsProfessorLista;
    private ObservableList<Curso> obsCursoLista;
    private ObservableList<Turma> obsTurmaLista;
    private ObservableList<Disciplina> obsDisciplinaLista;
    
        
    //METODOS PARA CARREGAR LISTAS
    public void carregarAlunosLista(){        
        obsAlunoLista = FXCollections.observableArrayList(administrador.getAlunos());
        lvAlunos.setItems(obsAlunoLista); 
        
        contadorAlunos.setText(Integer.toString(administrador.getAlunos().size()));
    }
    public void carregarProfessoresLista(){        
        obsProfessorLista = FXCollections.observableArrayList(administrador.getProfessores());
        lvProfessores.setItems(obsProfessorLista);   
        
        contadorProfessores.setText(Integer.toString(administrador.getProfessores().size()));
    }
    public void carregarCursosLista(){        
        obsCursoLista = FXCollections.observableArrayList(administrador.getCursos());
        lvCursos.setItems(obsCursoLista);  
        
        contadorCursos.setText(Integer.toString(administrador.getCursos().size()));
   
    }
    public void carregarTurmasLista(){        
        obsTurmaLista = FXCollections.observableArrayList(administrador.getTurmas());
        lvTurmas.setItems(obsTurmaLista);    
        
        contadorTurmas.setText(Integer.toString(administrador.getTurmas().size()));
    }
    public void carregarDisciplinasLista(){        
        obsDisciplinaLista = FXCollections.observableArrayList(administrador.getDisciplinas());
        lvDisciplinas.setItems(obsDisciplinaLista);  
        
        contadorDisciplinas.setText(Integer.toString(administrador.getDisciplinas().size()));
    }
    
    
    //MENUS DA TELA
    @FXML
    void abrirSecaoRegistro(ActionEvent event) {
        rbtnAluno.setSelected(true);
        paneRegistro.setVisible(true);
        gridAluno.setVisible(true);
        gridProfessor.setVisible(false);

        paneCriacao.setVisible(false); 
        paneEditar.setVisible(false);
        paneListar.setVisible(false);
        
        lblSaudacao.setVisible(false);
        imvSaudacao.setVisible(false);

    }
    
    @FXML
    void abrirSecaoCriar(ActionEvent event) {
        rbtnCurso.setSelected(true);
        paneCriacao.setVisible(true);
        gridCurso.setVisible(true);
        gridDisciplina.setVisible(false);
        gridTurma.setVisible(false);

        paneRegistro.setVisible(false); 
        paneEditar.setVisible(false);
        paneListar.setVisible(false);
        
        lblSaudacao.setVisible(false);
        imvSaudacao.setVisible(false);

    }
    
    @FXML
    void abrirSecaoLIstar(ActionEvent event) {
        rbtnAlunosListar.setSelected(true);
        paneListar.setVisible(true);
        gridListaAlunos.setVisible(true);
        gridListaCursos.setVisible(false);
        gridListaDisciplinas.setVisible(false);
        gridListaProfessores.setVisible(false);
        gridListaTurmas.setVisible(false);

        paneRegistro.setVisible(false); 
        paneCriacao.setVisible(false);
        paneEditar.setVisible(false);
        
        lblSaudacao.setVisible(false);
        imvSaudacao.setVisible(false);
        
        carregarAlunosLista();
        carregarProfessoresLista();
        carregarCursosLista();
        carregarTurmasLista();
        carregarDisciplinasLista();

    }

    @FXML
    void abrirSecaoEditar(ActionEvent event) {
        paneEditar.setVisible(true);

        paneRegistro.setVisible(false); 
        paneCriacao.setVisible(false);
        paneListar.setVisible(false);
        
        lblSaudacao.setVisible(false);
        imvSaudacao.setVisible(false);

    }
    
    
   @FXML
    void sair(ActionEvent event) {
        //MOSTRANDO COMO TELA DE INICIO NOVAMENTE PARA O PROXIMO LOGIN
        imvSaudacao.setVisible(true);
        lblSaudacao.setVisible(true);
        
        //DEIXANDO INVISIVEL OS MENUS NAO ATIVOS
        paneRegistro.setVisible(false); 
        gridAluno.setVisible(false);
        gridProfessor.setVisible(false);
        paneCriacao.setVisible(false);
        paneListar.setVisible(false);
        paneEditar.setVisible(false);
        
        
        System.out.println("#--------Saindo--------#");        
        Main.trocarTela("login");
    }

    
//=============== SUBMENUS ==============================
    
    //------------> ITEM REGISTRAR
    @FXML
    void abreGridAluno(ActionEvent event) {
        gridAluno.setVisible(true);
        gridProfessor.setVisible(false);
    }

    @FXML
    void abreGridProfessor(ActionEvent event) {
        gridProfessor.setVisible(true);
        gridAluno.setVisible(false);

    }
    
    //**********METODOS INCLUIDOS REGISTRAR
    @FXML
    void registrarAluno(ActionEvent event) {
        String nome = txtNomeAluno.getText().toUpperCase();
        String cpf = txtCPFAluno.getText().toUpperCase();
        String matricula = txtMatriculaAluno.getText().toUpperCase();
        Curso cursoObj = cboxCursoAluno.getSelectionModel().getSelectedItem();
        
        if(txtNomeAluno.getText().equals("") || txtCPFAluno.getText().equals("") || txtMatriculaAluno.getText().equals("") || 
            cboxCursoAluno.getSelectionModel().getSelectedItem() == null){
            erroCampo();
            //System.out.println("H?? campos vazios!");
        }else{
            if( administrador.registrarAluno(nome, cpf, matricula, cursoObj) == 0){
                obsPessoa = FXCollections.observableArrayList(administrador.getPessoas());

                registroRealizado(nome,matricula+"01");
            }else{
                erroJaExiste();
            }
        
            
        }
        
        //ZERANDO OS CAMPOS
        txtNomeAluno.setText("");
        txtCPFAluno.setText("");
        cboxCursoAluno.getSelectionModel().clearSelection();
        txtMatriculaAluno.setText("");
        
        System.out.println(administrador.getAlunos());
        
        //CONTADOR ALUNO
        contadorAlunos.setText(Integer.toString(administrador.getAlunos().size()));

    }

    @FXML
    void registrarProfessor(ActionEvent event) {
        String nome = txtNomeProfessor.getText().toUpperCase();
        String cpf = txtCPFProfessor.getText().toUpperCase();
        String area = txtAreaProfessor.getText().toUpperCase();
        String matricula = txtMatriculaProfessor.getText().toUpperCase();
        Curso cursoObj = cboxCursoProfessor.getSelectionModel().getSelectedItem();
        
        if(txtNomeProfessor.getText().equals("") || txtCPFProfessor.getText().equals("") || txtAreaProfessor.getText().equals("") ||
                txtMatriculaProfessor.getText().equals("") || cboxCursoProfessor.getSelectionModel().getSelectedItem() == null){
            erroCampo();
            // System.out.println("H?? campos vazios!");
        }else{
            if(administrador.registrarProfessor(nome, cpf, area, matricula, cursoObj) == 0){
                //Cbox PROFESSOR
                obsProfessores = FXCollections.observableArrayList(administrador.getProfessores());
                cboxProfessor.setItems(obsProfessores);
                cboxProfessorEditar.setItems(obsProfessores);

                obsPessoa = FXCollections.observableArrayList(administrador.getPessoas());
                registroRealizado(nome,matricula+"02");
                
            }else{
               erroJaExiste();
            }
        
            
            
        }
        //ZERANDO OS CAMPOS
        txtNomeProfessor.setText("");
        txtCPFProfessor.setText("");
        cboxCursoProfessor.getSelectionModel().clearSelection();
        txtMatriculaProfessor.setText("");
        txtAreaProfessor.setText("");
        
        System.out.println(administrador.getProfessores());
        
        //CONTADOR PROFESSOR
        contadorProfessores.setText(Integer.toString(administrador.getProfessores().size()));
    }

    
    //------------> ITEM CRIAR
    @FXML
    void abreGridCurso(ActionEvent event) {
        gridCurso.setVisible(true);
        
        gridDisciplina.setVisible(false);
        gridTurma.setVisible(false);
    }
    
    @FXML
    void abreGridTurma(ActionEvent event) {
        gridTurma.setVisible(true);
        
        gridCurso.setVisible(false);
        gridDisciplina.setVisible(false);
    }
    
    @FXML
    void abregridDisciplina(ActionEvent event) {
        gridDisciplina.setVisible(true);
        
        gridCurso.setVisible(false);
        gridTurma.setVisible(false);
    }
    
    //**********METODOS INCLUIDOS CRIAR
    @FXML
    void criarCurso(ActionEvent event) {
        String nome = txtNomeCurso.getText().toUpperCase();

        if(txtNomeCurso.getText().equals("") || txtNomeCurso.getText().equals(null) ){
            //System.out.println("H?? campos vazios!");
            erroCampo();
        }else{
            administrador.criarCurso(nome);

            System.out.println(administrador.getCursos());

            //CURSOS CBOX
            obsCursos = FXCollections.observableArrayList(administrador.getCursos());
            cboxCurso.setItems(obsCursos);
            cboxCursoAluno.setItems(obsCursos);
            cboxCursoDisciplina.setItems(obsCursos);
            cboxCursoProfessor.setItems(obsCursos);

            //LISTA
            lvCursos.setItems(obsCursos);
            
            cadastroEfetuado(nome);
        }
        
        
        
        txtNomeCurso.setText("");
        
        //CONTADOR DE CURSOS
        contadorCursos.setText(Integer.toString(administrador.getCursos().size()));

    }

    @FXML
    void criarDisciplina(ActionEvent event) {
        String nome = txtNomeDisciplina.getText().toUpperCase();
        Curso curso = cboxCursoDisciplina.getSelectionModel().getSelectedItem();
        
        if(txtNomeDisciplina.getText().equals("") || cboxCursoDisciplina.getSelectionModel().getSelectedItem() == null){
            //System.out.println("H?? CAMPOS VAZIOS");
            erroCampo();
        }else{
            if(administrador.criarDisciplina(nome, curso) == 0){
                System.out.println(administrador.getDisciplinas());


                //DISCIPLINAS CBOX
                obsDisciplinas = FXCollections.observableArrayList(administrador.getDisciplinas());
                cboxDisciplina.setItems(obsDisciplinas);

                //LISTA
                lvDisciplinas.setItems(obsDisciplinas);

                cadastroEfetuado(nome);
            }else{
                erroJaExiste();
            }
        
            
        }
  
        txtNomeDisciplina.setText("");
        cboxCursoDisciplina.getSelectionModel().clearSelection();
        
        //CONTADOR DISCIPLINAS
        contadorDisciplinas.setText(Integer.toString(administrador.getDisciplinas().size()));


    }

    @FXML
    void criarTurma(ActionEvent event) {
        String codigo = txtNumTurma.getText().toUpperCase();
        Curso curso = cboxCurso.getSelectionModel().getSelectedItem();
        Disciplina disciplina = cboxDisciplina.getSelectionModel().getSelectedItem();
        Professor professor = cboxProfessor.getSelectionModel().getSelectedItem();
        
        if(txtNumTurma.getText().equals("") || cboxCurso.getSelectionModel().getSelectedItem() == null || 
                cboxDisciplina.getSelectionModel().getSelectedItem() == null 
                || cboxProfessor.getSelectionModel().getSelectedItem() == null){
            erroCampo();
        }else{
            if(administrador.criarTurma(codigo, curso, disciplina, professor) == 0){
                System.out.println(administrador.getTurmas());
                //TURMAS CBOX
                obsTurmas = FXCollections.observableArrayList(administrador.getTurmas());
                //cboxTurma.setItems(obsTurmas);
                cboxTurmaEditar.setItems(obsTurmas);
                //LISTA
                lvTurmas.setItems(obsTurmas);

                cadastroEfetuado(codigo+"-"+disciplina);
            }else{
                erroJaExiste();
            }
        
                    
        }
              
        txtNumTurma.setText("");
        cboxCurso.getSelectionModel().clearSelection();
        cboxDisciplina.getSelectionModel().clearSelection();
        cboxProfessor.getSelectionModel().clearSelection();
        
        //CONTADOR TURMAS
        contadorTurmas.setText(Integer.toString(administrador.getTurmas().size()));

    }
    
    //------------> ITEM LISTAR
    
    

    @FXML
    void abreGridAlunoLista(ActionEvent event) {
        gridListaAlunos.setVisible(true);
        
        gridListaCursos.setVisible(false);
        gridListaDisciplinas.setVisible(false);
        gridListaProfessores.setVisible(false);
        gridListaTurmas.setVisible(false);

    }

    @FXML
    void abreGridCursoLista(ActionEvent event) {
        gridListaCursos.setVisible(true);
        
        gridListaAlunos.setVisible(false);
        gridListaDisciplinas.setVisible(false);
        gridListaProfessores.setVisible(false);
        gridListaTurmas.setVisible(false);

    }

    @FXML
    void abreGridDisciplinasLista(ActionEvent event) {
        gridListaDisciplinas.setVisible(true);
        
        gridListaAlunos.setVisible(false);
        gridListaCursos.setVisible(false);
        gridListaProfessores.setVisible(false);
        gridListaTurmas.setVisible(false);

    }

    @FXML
    void abreGridProfessorLista(ActionEvent event) {
        gridListaProfessores.setVisible(true);
        
        gridListaAlunos.setVisible(false);
        gridListaCursos.setVisible(false);
        gridListaDisciplinas.setVisible(false);
        gridListaTurmas.setVisible(false);

    }

    @FXML
    void abreGridTurmasLista(ActionEvent event) {
        gridListaTurmas.setVisible(true);
        
        gridListaAlunos.setVisible(false);
        gridListaCursos.setVisible(false);
        gridListaDisciplinas.setVisible(false);
        gridListaProfessores.setVisible(false);

    }
    
    //**********METODOS INCLUIDOS LISTAR
    
    @FXML
    void verProfessorLista(ActionEvent event) {
        Professor professor = lvProfessores.getSelectionModel().getSelectedItem();
        verItemListaAlunoProfessor(professor.getCurso().toString(), professor.getNome(), professor.getMatricula());  
    }

    @FXML
    void verTurmasLista(ActionEvent event) {
        Turma turma = lvTurmas.getSelectionModel().getSelectedItem();
        verItemListaTurma(turma.getCodigo(), turma.getProfessor().toString());
    }
    
    @FXML
    void verAlunoLista(ActionEvent event) {
        Aluno aluno = lvAlunos.getSelectionModel().getSelectedItem();
        verItemListaAlunoProfessor(aluno.getCurso().toString(), aluno.getNome(), aluno.getMatricula());          
    }

    @FXML
    void verCursosLista(ActionEvent event) {
        Curso curso = lvCursos.getSelectionModel().getSelectedItem();
        verItemListaCurso(curso.getNome());
    }

    @FXML
    void verDisciplinasLista(ActionEvent event) {
        Disciplina disciplina = lvDisciplinas.getSelectionModel().getSelectedItem();
        verItemListaDisciplina(disciplina.getNome(), disciplina.getCurso());
    }

    @FXML
    void removerAlunoLista(ActionEvent event) {
        removido(lvAlunos.getSelectionModel().getSelectedItem().getNome());
        
        administrador.getPessoas().remove(lvAlunos.getSelectionModel().getSelectedItem());
        obsPessoa.remove(lvAlunos.getSelectionModel().getSelectedItem());
        
        administrador.getAlunos().remove(lvAlunos.getSelectionModel().getSelectedItem());
        obsAlunoLista.remove(lvAlunos.getSelectionModel().getSelectedItem());
            
        contadorAlunos.setText(Integer.toString(administrador.getAlunos().size()));
        
        obsPessoa = FXCollections.observableArrayList(administrador.getPessoas());

    }

    @FXML
    void removerCursosLista(ActionEvent event) {
        removido(lvCursos.getSelectionModel().getSelectedItem().getNome());
        
        administrador.getCursos().remove(lvCursos.getSelectionModel().getSelectedItem());
        obsCursoLista.remove(lvCursos.getSelectionModel().getSelectedItem());
        
        contadorCursos.setText(Integer.toString(administrador.getCursos().size()));
        
        //CURSOS CBOX
        obsCursos = FXCollections.observableArrayList(administrador.getCursos());
        cboxCurso.setItems(obsCursos);
        cboxCursoAluno.setItems(obsCursos);
        cboxCursoDisciplina.setItems(obsCursos);
        cboxCursoProfessor.setItems(obsCursos);
    }

    @FXML
    void removerDisciplinasLista(ActionEvent event) {
        removido(lvDisciplinas.getSelectionModel().getSelectedItem().getNome());
        
        administrador.getDisciplinas().remove(lvDisciplinas.getSelectionModel().getSelectedItem());
        obsDisciplinaLista.remove(lvDisciplinas.getSelectionModel().getSelectedItem());
        
        contadorDisciplinas.setText(Integer.toString(administrador.getDisciplinas().size()));
        
        //DISCIPLINAS CBOX
        obsDisciplinas = FXCollections.observableArrayList(administrador.getDisciplinas());
        cboxDisciplina.setItems(obsDisciplinas);
    }
    
    @FXML
    void removerProfessorLista(ActionEvent event) {
        removido(lvProfessores.getSelectionModel().getSelectedItem().getNome());
         //REMOVENDO DE PESSOAS
        administrador.getPessoas().remove(lvProfessores.getSelectionModel().getSelectedItem());
        obsPessoa.remove(lvProfessores.getSelectionModel().getSelectedItem());
        //REMOVENDO DE PROFESSORES
        administrador.getProfessores().remove(lvProfessores.getSelectionModel().getSelectedItem());
        obsProfessorLista.remove(lvProfessores.getSelectionModel().getSelectedItem());       
        
        contadorProfessores.setText(Integer.toString(administrador.getProfessores().size()));
        
        //Cbox PROFESSOR
        obsProfessores = FXCollections.observableArrayList(administrador.getProfessores());
        cboxProfessor.setItems(obsProfessores);
        cboxProfessorEditar.setItems(obsProfessores);
        obsPessoa = FXCollections.observableArrayList(administrador.getPessoas());
        
    }

    @FXML
    void removerTurmasLista(ActionEvent event) {
        removido(lvTurmas.getSelectionModel().getSelectedItem().getCodigo());
        
        administrador.getTurmas().remove(lvTurmas.getSelectionModel().getSelectedItem());
        obsTurmaLista.remove(lvTurmas.getSelectionModel().getSelectedItem());
        
        contadorTurmas.setText(Integer.toString(administrador.getTurmas().size()));
        
        //TURMAS CBOX
        obsTurmas = FXCollections.observableArrayList(administrador.getTurmas());
        //cboxTurma.setItems(obsTurmas);
        cboxTurmaEditar.setItems(obsTurmas);
    }
    
        

    //------------> ITEM EDITAR

    @FXML
    void mudarProfessor(ActionEvent event) {
        Turma turma = cboxTurmaEditar.getSelectionModel().getSelectedItem();
        Professor professor = cboxProfessorEditar.getSelectionModel().getSelectedItem();        
        administrador.getTurmas().get( administrador.getTurmas().indexOf(turma)).setProfessor(professor);
        System.out.println(administrador.getTurmas().get( administrador.getTurmas().indexOf(turma)));
        
        cboxTurmaEditar.getSelectionModel().clearSelection();
        cboxProfessorEditar.getSelectionModel().clearSelection();
        
        //System.out.println("ATUALIZADO");
        
        atualizado(professor.getNome(), turma.getCodigo());
    }   
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //CAREGANDO A IMAGEM DO USER
        Image image1 = new Image("/sistemaacademico/images/user.png");
        imgvUser.setImage(image1);
        
        Image image2 = new Image("/sistemaacademico/images/administrador.boasvindas.png");
        imvSaudacao.setImage(image2);
        
        //MOSTRANDO COMO TELA DE INICIO
        imvSaudacao.setVisible(true);
        lblSaudacao.setVisible(true);
        
        //DEIXANDO INVISIVEL OS MENUS NAO ATIVOS
        paneRegistro.setVisible(false); 
        gridAluno.setVisible(false);
        gridProfessor.setVisible(false);
        paneCriacao.setVisible(false);
        paneListar.setVisible(false);
        paneEditar.setVisible(false);
        
        //DEFININDO MATRICULA NA INTEFACE
        lblmatricula.setText(administrador.getMatricula());       
            

        alert2.setResizable(true);        
        
    }  

}
