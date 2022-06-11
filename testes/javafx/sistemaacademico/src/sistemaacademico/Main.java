package sistemaacademico;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sistemaacademico.model.Administrador;

/**
 *
 * @author DessimA
 */
public class Main extends Application {

    // INSTANCIAS DAS OUTRAS CLASSES
    private final static Main instance = new Main();

    public static Main getInstance() {
        return instance;
    }

    private Administrador administrador = new Administrador();

    public Administrador administrador() {
        return administrador;
    }

    // ---------------------------------------

    private static Stage novoStage;

    private static Scene loginScene;
    private static Scene administradorScene;
    private static Scene alunoScene;
    private static Scene professorScene;

    @Override
    public void start(Stage stage) throws Exception {
        novoStage = stage;

        // LOGIN
        Parent login = FXMLLoader.load(getClass().getResource("view/FXMLTelaLogin.fxml"));
        loginScene = new Scene(login);

        // COORDENADOR
        Parent administrador = FXMLLoader.load(getClass().getResource("view/FXMLTelaAdmin.fxml"));
        administradorScene = new Scene(administrador);

        // ALUNO
        Parent aluno = FXMLLoader.load(getClass().getResource("view/FXMLTelaAluno.fxml"));
        alunoScene = new Scene(aluno);

        // PROFESSOR
        Parent professor = FXMLLoader.load(getClass().getResource("view/FXMLTelaProfessor.fxml"));
        professorScene = new Scene(professor);

        stage.setResizable(false); // Bloqueia o redimensionamento
        stage.setScene(loginScene); // COMECA COM A TELA DE LOGIN
        stage.setTitle("Sistema Academico v0.1");
        stage.show();
    }

    public static void trocarTela(String nomeTela) {
        switch (nomeTela) {
            case ("administrador"):
                novoStage.setScene(administradorScene);
                break;
            case ("aluno"):
                novoStage.setScene(alunoScene);
                break;
            case ("professor"):
                novoStage.setScene(professorScene);
                break;
            case ("login"):
                novoStage.setScene(loginScene);
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
