package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ModelDAO.Disciplina;


public class DisciplinaDAOImpl implements DisciplinaDAO{

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/academico";

	// Database credentials
	static final String USER = "postgres";
	static final String PASS = "admin";
		
	static final String INSERT = "INSERT INTO disciplina (nome_disciplina, id_semestre) VALUES (?, ?)";
	static final String UPDATE = "UPDATE disciplina SET nome_disciplina=? where id=?";
	static final String FIND_BY_ID = "SELECT * FROM disciplina WHERE id=?";
	static final String FIND_ALL = "SELECT * FROM disciplina";
	
	
	@Override
	public int create(Disciplina disciplina) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int ret=0;
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, disciplina.getNome());
			pstmt.setDouble(2, disciplina.getIdSemestre());
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		return ret;
	}

	@Override
	public Disciplina findById(Double id) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		Disciplina disciplina = null;
		
		try {
			pstmt = conn.prepareStatement(FIND_BY_ID);
			pstmt.setDouble(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				disciplina = new Disciplina();
				disciplina.setId(rs.getDouble(1));
				disciplina.setNome(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return disciplina;
	}

	@Override
	public List<Disciplina> findAll() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		List<Disciplina> l = new ArrayList<Disciplina>();
		try {
			pstmt = conn.prepareStatement(FIND_ALL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Disciplina disciplina = new Disciplina();
				disciplina.setId(rs.getDouble(1));
				disciplina.setNome(rs.getString(2));	
				l.add(disciplina);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return l;
	}
	
	
	Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			return DriverManager.getConnection(
					DB_URL,USER,PASS);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	void close (Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	void close (Statement stmt) {
		if (stmt != null)
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	
}
