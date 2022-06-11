
package sistemaacademico.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import sistemaacademico.Main;
import sistemaacademico.model.Aluno;
import sistemaacademico.model.Administrador;
import sistemaacademico.model.Pessoa;
import sistemaacademico.model.Turma;

/**
 * FXML Controller class
 *
 * @author DessimA
 */
public class FXMLTelaAlunoController implements Initializable {

    @FXML
    private ImageView imgvUser;

    @FXML
    private Label lblmatricula;

    @FXML
    private Label lblNome;

    @FXML
    private JFXTextArea areaTexto;

    @FXML
    private JFXComboBox<Pessoa> cboxDestinatario;

    @FXML
    private JFXCheckBox ckeckAdministrador;

    @FXML
    private Pane paneTurmasDisponiveis;

    @FXML
    private Label contadorTurmasDisponiveis;

    @FXML
    private JFXListView<Turma> lvTurmas;

    @FXML
    private Pane paneTurmasAluno;

    @FXML
    private Label contadorTurmasAluno;

    @FXML
    private JFXListView<Turma> lvTurmasAluno;

    @FXML
    private Label lblSaudacao;

    @FXML
    private ImageView imvSaudacao;

    @FXML
    private ImageView imgvLogo;

    // CHAMANDO ADMINISTRADOR
    Administrador administrador = Main.getInstance().administrador();

    // COMBOBOXS

    // LISTAS
    private ObservableList<Turma> obsTurmasAluno;
    private ObservableList<Turma> obsTurmasDisponiveis;

    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);

    public void trancar() {
        alert2.setTitle("TRANCADA");
        alert2.setHeaderText(null);
        alert2.setContentText("Essa disciplina foi trancada");
        alert2.show();
    }

    public void matricular(String item) {
        alert2.setTitle("MATRICULADO!");
        alert2.setHeaderText(null);
        alert2.setContentText(item + " adicionado!");
        alert2.show();
    }

    public void removido(String item) {
        alert2.setTitle("REMOVIDO");
        alert2.setHeaderText(null);
        alert2.setContentText(item + " foi removido");
        alert2.show();
    }

    // CARREGAR LISTAS-CBOX
    public void carregarTurmasAlunoLista() {
        Aluno aluno = administrador.getAlunos().get(administrador.getIndexUsuarioTela());

        obsTurmasAluno = FXCollections.observableArrayList(aluno.getTurmas());
        lvTurmasAluno.setItems(obsTurmasAluno);

        contadorTurmasAluno.setText(Integer.toString(aluno.getTurmas().size()));
    }

    public void carregarTurmasDisponiveis() {
        obsTurmasDisponiveis = FXCollections.observableArrayList(administrador.getTurmas());
        lvTurmas.setItems(obsTurmasDisponiveis);

        contadorTurmasDisponiveis.setText(Integer.toString(administrador.getTurmas().size()));
    }

    @FXML
    void abrirSecaoMatricular(ActionEvent event) {
        paneTurmasDisponiveis.setVisible(true);

        paneTurmasAluno.setVisible(false);

        imvSaudacao.setVisible(false);
        lblSaudacao.setVisible(false);

        carregarTurmasDisponiveis();

    }

    @FXML
    void abrirSecaoTurmas(ActionEvent event) {
        paneTurmasAluno.setVisible(true);

        paneTurmasDisponiveis.setVisible(false);

        imvSaudacao.setVisible(false);
        lblSaudacao.setVisible(false);

        if (administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getTurmas().size() > 0) {
            carregarTurmasAlunoLista();
        } else {
            System.out.println("O ALUNO AINDA NAO TEM TURMAS");
        }

    }

    @FXML
    void desabilitarOutros(ActionEvent event) {
        if (ckeckAdministrador.isSelected()) {
            cboxDestinatario.setDisable(true);
        } else {
            cboxDestinatario.setDisable(false);
        }
    }

    @FXML
    void matricularTurma(ActionEvent event) {
        if (administrador.getTurmas().size() > 0) {
            Turma turma = lvTurmas.getSelectionModel().getSelectedItem();
            administrador.getAlunos().get(administrador.getIndexUsuarioTela()).addTurma(turma);
            System.out.println("FEITO");

            matricular(turma.getCodigo());
        } else {
            System.out.println("NAO HA TURMAS");
        }

    }

    @FXML
    void sair(ActionEvent event) {
        System.out.println("-----SAINDO ALUNO------");
        Main.trocarTela("login");
    }

    @FXML
    void trancarTurma(ActionEvent event) {
        if (administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getTurmas().size() > 0) {
            trancar();

            administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getTurmas()
                    .remove(lvTurmasAluno.getSelectionModel().getSelectedItem());
            obsTurmasAluno.remove(lvTurmasAluno.getSelectionModel().getSelectedItem());

            contadorTurmasAluno.setText(Integer
                    .toString(administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getTurmas().size()));
        } else {
            System.out.println("NAO HA TURMAS");
        }
    }

    @FXML
    void sairLoading(ActionEvent event) {
        lblNome.setText(administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getNome());
        lblmatricula.setText(administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getMatricula());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
