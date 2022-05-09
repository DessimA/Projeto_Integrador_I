package sistemaacademico.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import sistemaacademico.Main;
import sistemaacademico.model.Administrador;
import sistemaacademico.model.Mensagem;
import sistemaacademico.model.Pessoa;
import sistemaacademico.model.Professor;

/**
 * FXML Controller class
 *
 * @author DessimA
 */
public class FXMLTelaProfessorController implements Initializable {

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
    
    //CHAMANDO COORDENADOR
    Administrador administrador = Main.getInstance().administrador();    
    
    //COMBOBOXS
    private ObservableList<Pessoa> obsDestinatario;

    //LISTAS
    private ObservableList<Mensagem> obsMensagens;
    
    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
    
    public void enviado(String destinatario){
       alert2.setTitle("ENVIADO");
       alert2.setHeaderText(null);
       alert2.setContentText("A mensagem foi enviada para "+destinatario);
       alert2.show();
    }
    public void verMensagem(String texto, String remetente){
       alert2.setTitle("MENSAGEM");
       alert2.setHeaderText("POR = "+remetente);
       alert2.setContentText(texto);
       
       alert2.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
       alert2.show();
    }
    public void removido(String item){
       alert2.setTitle("REMOVIDO");
       alert2.setHeaderText(null);
       alert2.setContentText(item+" foi removido");
       alert2.show();
    }
    
    public void carregarMensagens(){        
        Professor professor = administrador.getProfessores().get(administrador.getIndexUsuarioTela());
       
        obsMensagens = FXCollections.observableArrayList(professor.getInbox());
        lvMensagens.setItems(obsMensagens);    
        
        contadorInbox.setText(Integer.toString(professor.getInbox().size())); 
        contadorMensagens.setText(Integer.toString(professor.getInbox().size())); 
        
        contandoMensagens();
    }
    public void carregarPessoasDestinatarios(){        
        obsDestinatario = FXCollections.observableArrayList(administrador.getPessoas());
        cboxDestinatario.setItems(obsDestinatario);    
    }
    
    void contandoMensagens(){
        if(administrador.getProfessores().get(administrador.getIndexUsuarioTela()).getInbox().size() > 0){
            contadorInbox.setVisible(true);
            indicadorInbox.setVisible(true);
            contadorInbox.setText(Integer.toString(administrador.getProfessores().get(administrador.getIndexUsuarioTela()).getInbox().size()));
        }else{
            contadorInbox.setVisible(false);
            indicadorInbox.setVisible(false);
            contadorInbox.setText(Integer.toString(administrador.getProfessores().get(administrador.getIndexUsuarioTela()).getInbox().size()));
        }
    }
    
    @FXML
    void abrirSecaoEnviarMensagem(ActionEvent event) {
        paneEnviar.setVisible(true);
        
        paneInbox.setVisible(false);
        
        imvSaudacao.setVisible(false);
        lblSaudacao.setVisible(false);
        
        carregarPessoasDestinatarios();
    }

    @FXML
    void abrirSecaoInbox(ActionEvent event) {
        paneInbox.setVisible(true);
        
        paneEnviar.setVisible(false);
        
        imvSaudacao.setVisible(false);
        lblSaudacao.setVisible(false);
        
        carregarMensagens();
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
                administrador.getProfessores().get(administrador.getIndexUsuarioTela()).enviarMensagem(administrador, texto);
                System.out.println("enviado para administrador");
                enviado("administrador");
            }else{
                administrador.getProfessores().get(administrador.getIndexUsuarioTela()).enviarMensagem(destinatario,texto);
                System.out.println("enviado para "+destinatario.getNome());
                
                enviado(destinatario.getNome());
            }

            areaTexto.setText("");
            cboxDestinatario.getSelectionModel().clearSelection();

        }

    }

    @FXML
    void removerMensagem(ActionEvent event) {
        if(administrador.getProfessores().get(administrador.getIndexUsuarioTela()).getInbox().size() > 0){
            removido("Mensagem");
        
            administrador.getProfessores().get(administrador.getIndexUsuarioTela()).getInbox().remove(lvMensagens.getSelectionModel().getSelectedItem());
            obsMensagens.remove(lvMensagens.getSelectionModel().getSelectedItem());

            contadorMensagens.setText(Integer.toString(administrador.getProfessores().get(administrador.getIndexUsuarioTela()).getInbox().size()));
            contadorInbox.setText(Integer.toString(administrador.getProfessores().get(administrador.getIndexUsuarioTela()).getInbox().size()));
            System.out.println(administrador.getProfessores().get(administrador.getIndexUsuarioTela()).getInbox()); 
            
            if(administrador.getProfessores().get(administrador.getIndexUsuarioTela()).getInbox().size() == 0){
                contadorInbox.setVisible(false);
                indicadorInbox.setVisible(false);
            }
            
            
        }else{
            System.out.println("NAO HA MENSAGENS");
        }
    }

    @FXML
    void sair(ActionEvent event) {
        System.out.println("-----SAINDO PROFESSOR------");
        telaDeLoading.setVisible(true);
        Main.trocarTela("login");
    }

    @FXML
    void sairLoading(ActionEvent event) {
        lblNome.setText(administrador.getProfessores().get(administrador.getIndexUsuarioTela()).getNome());
        lblmatricula.setText(administrador.getProfessores().get(administrador.getIndexUsuarioTela()).getMatricula());
        carregarMensagens();
        telaDeLoading.setVisible(false);
    }

    @FXML
    void verMensagem(ActionEvent event) {
        if(administrador.getProfessores().get(administrador.getIndexUsuarioTela()).getInbox().size() > 0){
            Mensagem mensagem = lvMensagens.getSelectionModel().getSelectedItem();
            verMensagem(mensagem.getTexto(),mensagem.getRemetente());
        }else{
            System.out.println("NAO HA MENSAGENS AQUI");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        telaDeLoading.setVisible(true);
    }    
    
}
