package sistemaacademico.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sistemaacademico.Main;
import sistemaacademico.model.Administrador;
import sistemaacademico.model.Pessoa;

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
    private Pane telaDeLoading;

    @FXML
    private ImageView imgvLogo;
    
    //CHAMANDO COORDENADOR
    Administrador administrador = Main.getInstance().administrador();    
    
    //COMBOBOXS

    //LISTAS
    
    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
    
        
    public void removido(String item){
       alert2.setTitle("REMOVIDO");
       alert2.setHeaderText(null);
       alert2.setContentText(item+" foi removido");
       alert2.show();
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
    void sair(ActionEvent event) {
        System.out.println("-----SAINDO PROFESSOR------");
        telaDeLoading.setVisible(true);
        Main.trocarTela("login");
    }

    @FXML
    void sairLoading(ActionEvent event) {
        lblNome.setText(administrador.getProfessores().get(administrador.getIndexUsuarioTela()).getNome());
        lblmatricula.setText(administrador.getProfessores().get(administrador.getIndexUsuarioTela()).getMatricula());
        telaDeLoading.setVisible(false);
    }

   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        telaDeLoading.setVisible(true);
    }    
    
}
