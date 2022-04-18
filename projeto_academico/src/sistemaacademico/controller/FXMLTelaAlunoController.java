
package sistemaacademico.controller;


import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import sistemaacademico.Main;
import sistemaacademico.model.Aluno;
import sistemaacademico.model.Administrador;
import sistemaacademico.model.Mensagem;
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
    private Pane paneInbox;

    @FXML
    private Label contadorMensagens;

    @FXML
    private JFXListView<Mensagem> lvMensagens;

    @FXML
    private Pane paneEnviar;

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
    private Circle indicadorInbox;

    @FXML
    private Label contadorInbox;

    @FXML
    private Pane telaDeLoading;

    @FXML
    private ImageView imgvLogo;
    
    //CHAMANDO ADMINISTRADOR
    Administrador administrador = Main.getInstance().administrador();    
    
    //COMBOBOXS
    private ObservableList<Pessoa> obsDestinatario;

    //LISTAS
    private ObservableList<Turma> obsTurmasAluno;
    private ObservableList<Turma> obsTurmasDisponiveis;
    private ObservableList<Mensagem> obsMensagens;
    
    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
    
    public void trancar(){
       alert2.setTitle("TRANCADA");
       alert2.setHeaderText(null);
       alert2.setContentText("Essa disciplina foi trancada");
       alert2.show();
    }
    public void matricular(String item){
       alert2.setTitle("MATRICULADO!");
       alert2.setHeaderText(null);
       alert2.setContentText(item+" adicionado!");
       alert2.show();
    }
    public void enviado(String destinatario){
       alert2.setTitle("ENVIADO");
       alert2.setHeaderText(null);
       alert2.setContentText("A mensagem foi enviada para "+destinatario);
       alert2.show();
    }
    public void removido(String item){
       alert2.setTitle("REMOVIDO");
       alert2.setHeaderText(null);
       alert2.setContentText(item+" foi removido");
       alert2.show();
    }
    public void verMensagem(String texto, String remetente){
       alert2.setTitle("MENSAGEM");
       alert2.setHeaderText("POR = "+remetente);
       alert2.setContentText(texto);
       
       alert2.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
       alert2.show();
    }  
    
    //CARREGAR LISTAS-CBOX
    public void carregarTurmasAlunoLista(){  
        Aluno aluno = administrador.getAlunos().get(administrador.getIndexUsuarioTela());
       
        obsTurmasAluno = FXCollections.observableArrayList(aluno.getTurmas());
        lvTurmasAluno.setItems(obsTurmasAluno);    
        
        contadorTurmasAluno.setText(Integer.toString(aluno.getTurmas().size()));
    }   
    public void carregarTurmasDisponiveis(){        
        obsTurmasDisponiveis = FXCollections.observableArrayList(administrador.getTurmas());
        lvTurmas.setItems(obsTurmasDisponiveis);    
        
        contadorTurmasDisponiveis.setText(Integer.toString(administrador.getTurmas().size()));
    }
    
    public void carregarPessoasDestinatarios(){        
        obsDestinatario = FXCollections.observableArrayList(administrador.getPessoas());
        cboxDestinatario.setItems(obsDestinatario);    
    }
    public void carregarMensagens(){        
        Aluno aluno = administrador.getAlunos().get(administrador.getIndexUsuarioTela());
       
        obsMensagens = FXCollections.observableArrayList(aluno.getInbox());
        lvMensagens.setItems(obsMensagens);    
        
        contadorInbox.setText(Integer.toString(aluno.getInbox().size())); 
        contadorMensagens.setText(Integer.toString(aluno.getInbox().size())); 
        
        contandoMensagens();
    }

    @FXML
    void abrirSecaoEnviarMensagem(ActionEvent event) {
        paneEnviar.setVisible(true);
        
        paneInbox.setVisible(false);
        paneTurmasAluno.setVisible(false);
        paneTurmasDisponiveis.setVisible(false);
        
        imvSaudacao.setVisible(false);
        lblSaudacao.setVisible(false);
        
        carregarPessoasDestinatarios();

    }

    @FXML
    void abrirSecaoInbox(ActionEvent event) {
        paneInbox.setVisible(true);
        
        paneEnviar.setVisible(false);
        paneTurmasAluno.setVisible(false);
        paneTurmasDisponiveis.setVisible(false);
        
        imvSaudacao.setVisible(false);
        lblSaudacao.setVisible(false);
        
        carregarMensagens();
    }

    @FXML
    void abrirSecaoMatricular(ActionEvent event) {
        paneTurmasDisponiveis.setVisible(true);
        
        paneEnviar.setVisible(false);
        paneTurmasAluno.setVisible(false);
        paneInbox.setVisible(false);
        
        imvSaudacao.setVisible(false);
        lblSaudacao.setVisible(false);
        
        carregarTurmasDisponiveis();

    }

    @FXML
    void abrirSecaoTurmas(ActionEvent event) {
        paneTurmasAluno.setVisible(true);
        
        paneEnviar.setVisible(false);
        paneTurmasDisponiveis.setVisible(false);
        paneInbox.setVisible(false);
        
        imvSaudacao.setVisible(false);
        lblSaudacao.setVisible(false);
        
        if(administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getTurmas().size() > 0){
            carregarTurmasAlunoLista();
        }else{
            System.out.println("O ALUNO AINDA NAO TEM TURMAS");
        }
  
    }
    @FXML
    void desabilitarOutros(ActionEvent event) { 
        if(ckeckAdministrador.isSelected()){
            cboxDestinatario.setDisable(true);
        }else{
            cboxDestinatario.setDisable(false);
        }
    }

    @FXML
    void enviarMensagem(ActionEvent event) {       
        String texto = areaTexto.getText();
        Pessoa destinatario = cboxDestinatario.getSelectionModel().getSelectedItem();
       
        if(texto == null || texto.equals("")){
            System.out.println("VAZIO");
        }else{
            if(ckeckAdministrador.isSelected()){
                administrador.getAlunos().get(administrador.getIndexUsuarioTela()).enviarMensagem(administrador, texto);
                System.out.println("enviado para administrador");
                enviado("administrador");
            }else{
                administrador.getAlunos().get(administrador.getIndexUsuarioTela()).enviarMensagem(destinatario,texto);
                System.out.println("enviado para "+destinatario.getNome());
                
                enviado(destinatario.getNome());
            }

            areaTexto.setText("");
            cboxDestinatario.getSelectionModel().clearSelection();

        }

    }

    @FXML
    void matricularTurma(ActionEvent event) {
        if(administrador.getTurmas().size() > 0){
            Turma turma  = lvTurmas.getSelectionModel().getSelectedItem();
            administrador.getAlunos().get(administrador.getIndexUsuarioTela()).addTurma(turma);
            System.out.println("FEITO");   
            
            matricular(turma.getCodigo());
        }else{
            System.out.println("NAO HA TURMAS");
        }
        
    }

    @FXML
    void removerMensagem(ActionEvent event) {
        if(administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getInbox().size() > 0){
            removido("Mensagem");
        
            administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getInbox().remove(lvMensagens.getSelectionModel().getSelectedItem());
            obsMensagens.remove(lvMensagens.getSelectionModel().getSelectedItem());

            contadorMensagens.setText(Integer.toString(administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getInbox().size()));
            contadorInbox.setText(Integer.toString(administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getInbox().size()));
            System.out.println(administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getInbox()); 
            
            if(administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getInbox().size() == 0){
                contadorInbox.setVisible(false);
                indicadorInbox.setVisible(false);
            }
            
            
        }else{
            System.out.println("NAO HA MENSAGENS");
        }
        

    }

    @FXML
    void sair(ActionEvent event) {
        System.out.println("-----SAINDO ALUNO------");
        telaDeLoading.setVisible(true);
        Main.trocarTela("login");
    }
    
    @FXML
    void trancarTurma(ActionEvent event) {
       if(administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getTurmas().size() > 0){
            trancar();
        
            administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getTurmas().remove(lvTurmasAluno.getSelectionModel().getSelectedItem());
            obsTurmasAluno.remove(lvTurmasAluno.getSelectionModel().getSelectedItem());
        
            contadorTurmasAluno.setText(Integer.toString(administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getTurmas().size()));
       }else{
           System.out.println("NAO HA TURMAS");
       }
    }

    @FXML
    void verMensagem(ActionEvent event) {
        if(administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getInbox().size() > 0){
            Mensagem mensagem = lvMensagens.getSelectionModel().getSelectedItem();
            verMensagem(mensagem.getTexto(),mensagem.getRemetente());
        }else{
            System.out.println("NAO HA MENSAGENS AQUI");
        }

    }
    

    @FXML
    void sairLoading(ActionEvent event) {
        lblNome.setText(administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getNome());
        lblmatricula.setText(administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getMatricula());
        carregarMensagens();
        telaDeLoading.setVisible(false);
        
    }

    void contandoMensagens(){
        if(administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getInbox().size() > 0){
            contadorInbox.setVisible(true);
            indicadorInbox.setVisible(true);
            contadorInbox.setText(Integer.toString(administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getInbox().size()));
        }else{
            contadorInbox.setVisible(false);
            indicadorInbox.setVisible(false);
            contadorInbox.setText(Integer.toString(administrador.getAlunos().get(administrador.getIndexUsuarioTela()).getInbox().size()));
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        telaDeLoading.setVisible(true);
    }    
    
}
