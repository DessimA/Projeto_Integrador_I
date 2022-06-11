package com.sistema.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sistema.ModelDAO.Aluno;

public class AlunoDAOImpl implements AlunoDAO{

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/academico";

	// Database credentials
	static final String USER = "postgres";
	static final String PASS = "admin";
		
	static final String INSERT = "INSERT INTO aluno (nome, cpf, dataNascimento) VALUES ( ?, ?, ?)";
	static final String UPDATE = "UPDATE aluno SET nome=?, cpf=?, dataNascimento=? where id=?";
	static final String FIND_BY_ID = "SELECT * FROM aluno WHERE id=?";
	static final String FIND_ALL = "SELECT * FROM aluno";
	
	
	@Override
	public int create(Aluno aluno) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int ret=0;
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, aluno.getNome());
			pstmt.setString(2, aluno.getCpf());
			pstmt.setString(3, aluno.getDataNascimento());
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
	public int update(Aluno aluno) {
		return 0;
	}

	@Override
	public Aluno findById(Double id) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		Aluno aluno = null;
		
		try {
			pstmt = conn.prepareStatement(FIND_BY_ID);
			pstmt.setDouble(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				aluno = new Aluno();
				aluno.setId(rs.getDouble(1));
				aluno.setNome(rs.getString(2));
				aluno.setCpf(rs.getString(3));
				aluno.setDataNascimento(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return aluno;
	}

	@Override
	public List<Aluno> findAll() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		List<Aluno> l = new ArrayList<Aluno>();
		try {
			pstmt = conn.prepareStatement(FIND_ALL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Aluno aluno = new Aluno();
					aluno.setId(rs.getDouble(1));
					aluno.setNome(rs.getString(2));
					aluno.setCpf(rs.getString(3));
					aluno.setDataNascimento(rs.getString(4));
					
				l.add(aluno);
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
