package sistemaacademico.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sistemaacademico.Main;
import sistemaacademico.model.Administrador;
import javafx.scene.control.Alert;
/**
 *
 * @author DessimA
 */
public class FXMLTelaLoginController implements Initializable {
    
    @FXML
    private JFXTextField txtUsuario;

    @FXML
    private JFXPasswordField txtSenha;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private ImageView imgvLogo;

    @FXML
    private ImageView imgVpattern;
    
    Administrador administrador = Main.getInstance().administrador();
    Alert alert = new Alert(Alert.AlertType.ERROR);
    
   
    public void erroLogin(){
       alert.setTitle("Erro no Login");
       alert.setHeaderText("Acesso Negado!");
       alert.setContentText("Tente Novamente");
       alert.show();
    }
    
    public void limparCampos(){
        txtUsuario.setText("");
        txtSenha.setText("");
    }
    
    
    @FXML
    public void verificarLogin(){
        String matricula = txtUsuario.getText();
        String senha = txtSenha.getText();
        int tamUltimo = matricula.length()-1;
        boolean naoEncontrou = false;

        switch (matricula.charAt(tamUltimo)) {        
            case '1'://ALUNO
                if(administrador.getAlunos().size() != 0){
                    for(int i = 0; i < administrador.getAlunos().size(); i++){
                        if(matricula.equals(administrador.getAlunos().get(i).getMatricula()) && senha.equals(administrador.getAlunos().get(i).getSenha()) ){                       
                            naoEncontrou = false;
                            System.out.println("BEM VINDO ALUNO "+administrador.getAlunos().get(i).getNome());
                            System.out.println("index = "+i);
                            administrador.setIndexUsuarioTela(i);
                            limparCampos();
                            
                            administrador.setIndexUsuarioTela(i);
                            Main.trocarTela("aluno");
                            break;
                        }else{
                            naoEncontrou = true;
                        }
                    } 
                }if(naoEncontrou == true){
                    erroLogin();
                }
                break;
            
            case '2'://PROFESSOR
                if(administrador.getProfessores().size() != 0){
                    for(int i = 0; i < administrador.getProfessores().size(); i++){
                        if(matricula.equals(administrador.getProfessores().get(i).getMatricula()) && senha.equals(administrador.getProfessores().get(i).getSenha())){
                            System.out.println("BEM VINDO PROFESSOR");
                            System.out.println(administrador.getProfessores().get(i).getNome());
                            administrador.setIndexUsuarioTela(i);
                            System.out.println("index = "+i);
                            administrador.setIndexUsuarioTela(i);
                            limparCampos();

                            administrador.setIndexUsuarioTela(i);
                            Main.trocarTela("professor");
                            break;
                        }else{
                            naoEncontrou = true;
                        }
                    } 
                }if(naoEncontrou == true){
                    erroLogin();
                }
                break;
            case '0'://ADMINISTRADOR
                if(matricula.equals(administrador.getMatricula()) && senha.equals(administrador.getSenha())){
                    System.out.println("BEM VINDO ADMINISTRADOR"); 
                    
                    limparCampos();
                    
                    Main.trocarTela("administrador");
                }else{
                    erroLogin();
                }
                break;
            default:
                erroLogin();
                break;
        }
            
     }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //CAREGANDO A IMAGEM DO LOGO
        Image image = new Image("/sistemaacademico/images/logo.png");
        imgvLogo.setImage(image);
        Image image2 = new Image("/sistemaacademico/images/pattern.png");
        imgVpattern.setImage(image2);
        
        txtUsuario.setText("100");
        txtSenha.setText("1234");

    }
    
    
    
}
