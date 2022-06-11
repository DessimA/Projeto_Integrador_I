package com.sistema.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database{
	
		// BANCO DE DADOS //
		static final String JDBC_DRIVE = "org.postgresql.Driver";
		static final String DB_URL = "jdbc:postgresql://localhost:5432/academico";
		
		static final String USER = "postgres";
		static final String PASS = "admin";
	
		Connection conn = null;
        Statement stnt = null;

        
        public void connect() {
        	try {
    			Class.forName(JDBC_DRIVE);
    			System.out.println("Conectando ao banco...");
    			conn = DriverManager.getConnection(DB_URL, USER, PASS);
    			System.out.println("Conex�o com sucesso.");
    			System.out.println("Criando um statement");
    			stnt = conn.createStatement();
    		} catch (SQLException e) {
    				e.printStackTrace();
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		}
      }
      
      public void disconnect() {
    	  try {
    		System.out.println("Desconectando ao banco...");
			conn.close();
			stnt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	  
      }
}