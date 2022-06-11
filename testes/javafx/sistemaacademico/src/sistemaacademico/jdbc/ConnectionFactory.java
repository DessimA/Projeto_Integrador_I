package sistemaacademico.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        String nomeUsuario = "postgres";
        String senhaUsuario = "admin";
        String nomeBanco = "academicoteste";
        String enderecoServidor = "localhost";

        try {
            return DriverManager.getConnection("jdbc:postgresql://"+enderecoServidor+
            "/"+nomeBanco, nomeUsuario, senhaUsuario);
        } catch (SQLException e) {   
            System.out.println("Erro no jdbc -> ConnectionFactory");         
            throw new RuntimeException(e);
        }

    }
    
}
