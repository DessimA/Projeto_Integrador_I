package com.sistema.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sistema.ModelDAO.Professor;

public class ProfessorDAOImpl implements ProfessorDAO{

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/academico";

	// Database credentials
	static final String USER = "postgres";
	static final String PASS = "admin";
		
	static final String INSERT = "INSERT INTO professor (nome, cpf, dataNascimento) VALUES ( ?, ?, ?)";
	static final String UPDATE = "UPDATE professor SET nome=?, cpf=?, dataNascimento=? where id=?";
	static final String FIND_BY_ID = "SELECT * FROM professor WHERE id=?";
	static final String FIND_ALL = "SELECT * FROM professor";
	
	
	@Override
	public int create(Professor professor) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int ret=0;
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, professor.getNome());
			pstmt.setString(2, professor.getCpf());
			pstmt.setString(3, professor.getDataNascimento());
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
	public int update(Professor professor) {
		return 0;
	}

	@Override
	public Professor findById(Double id) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		Professor professor = null;
		
		try {
			pstmt = conn.prepareStatement(FIND_BY_ID);
			pstmt.setDouble(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				professor = new Professor();
				professor.setId(rs.getDouble(1));
				professor.setNome(rs.getString(2));
				professor.setCpf(rs.getString(3));
				professor.setDataNascimento(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return professor;
	}

	@Override
	public List<Professor> findAll() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		List<Professor> l = new ArrayList<Professor>();
		try {
			pstmt = conn.prepareStatement(FIND_ALL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Professor professor = new Professor();
				professor.setId(rs.getDouble(1));
				professor.setNome(rs.getString(2));
				professor.setCpf(rs.getString(3));
				professor.setDataNascimento(rs.getString(4));
					
				l.add(professor);
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
