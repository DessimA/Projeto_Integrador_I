package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ModelDAO.Administrador;

public class AdministradorDAOImpl implements AdministradorDAO{

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/academico";

	// Database credentials
	static final String USER = "postgres";
	static final String PASS = "admin";
		
	static final String INSERT = "INSERT INTO administrador (nome, cpf, dataNascimento) VALUES ( ?, ?, ?)";
	static final String UPDATE = "UPDATE administrador SET nome=?, cpf=?, dataNascimento=?  where id=?";
	static final String FIND_BY_ID = "SELECT * FROM administrador WHERE id=?";
	static final String FIND_ALL = "SELECT * FROM administrador";
	
	
	@Override
	public int create(Administrador adm) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int ret=0;
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, adm.getNome());
			pstmt.setString(2, adm.getCpf());
			pstmt.setString(3, adm.getDataNascimento());
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
	public int update(Administrador adm) {
		return 0;
	}

	@Override
	public Administrador findById(Double id) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		Administrador adm = null;
		
		try {
			pstmt = conn.prepareStatement(FIND_BY_ID);
			pstmt.setDouble(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				adm = new Administrador();
				adm.setId(rs.getDouble(1));
				adm.setNome(rs.getString(2));
				adm.setCpf(rs.getString(3));
				adm.setDataNascimento(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return adm;
	}

	@Override
	public List<Administrador> findAll() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		List<Administrador> l = new ArrayList<Administrador>();
		try {
			pstmt = conn.prepareStatement(FIND_ALL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Administrador adm = new Administrador();
					adm.setId(rs.getDouble(1));
					adm.setNome(rs.getString(2));
					adm.setCpf(rs.getString(3));
					adm.setDataNascimento(rs.getString(4));
					
				l.add(adm);
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
