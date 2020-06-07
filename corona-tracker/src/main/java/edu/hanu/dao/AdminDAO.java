package edu.hanu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import edu.hanu.model.Admin;
import edu.hanu.service.PasswordAuthentication;
import edu.hanu.utils.DbUtils;

public class AdminDAO {
	private static final String INSERT_QUERRY = "INSERT INTO admintbl VALUES(?,?)";
	private static final String SELECT_ALL_QUERRY = "SELECT * FROM admintbl";
	private static final String UPDATE_QUERRY = "UPDATE admintbl SET password = ? WHERE username= ?";
	private static final String DELETE_QUERRY = "DELETE FROM admintbl WHERE username= ?";
	private PasswordAuthentication authentication = new PasswordAuthentication();
	
	@SuppressWarnings({ "static-access", "deprecation" })
	public void insertAdmin(Admin admin) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("AdminDAO.insertAdmin: Connection is null !");
			}
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(INSERT_QUERRY);
			ps.setString(1, admin.getUsername());
			ps.setString(2, authentication.hash(admin.getPassword()));
			ps.execute();
			System.out.println(ps.toString());
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtils.closeConnection(conn);
			DbUtils.closePreparedStatement(ps);
		}
	}
	public List<Admin> getAllAdmin() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Admin> admins = new ArrayList<Admin>();
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("AdminDAO.getAllAdmin: Connection is null");
			}
			ps = conn.prepareStatement(SELECT_ALL_QUERRY);
			rs = ps.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admins.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DbUtils.closeResultSet(rs);
			DbUtils.closePreparedStatement(ps);
			DbUtils.closeConnection(conn);
		}
		return admins;
	}
	public void deleteAdmin(String username) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("AdminDAO.deleteAdmin: Connection is null ! ");
			}
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(DELETE_QUERRY);
			ps.setString(1, username);
			ps.execute();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtils.closePreparedStatement(ps);
			DbUtils.closeConnection(conn);
		}
	}
	@SuppressWarnings({ "static-access", "deprecation" })
	public void updateADmin(Admin admin) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("AdminDAO.updateAdmin: Connection is null");
			}
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(UPDATE_QUERRY);
			ps.setString(1, authentication.hash(admin.getPassword()));
			ps.setString(2, admin.getUsername());
			ps.execute();
			System.out.println(ps.toString());
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtils.closePreparedStatement(ps);
			DbUtils.closeConnection(conn);
		}
	}
	
	public static void main(String[] args) throws SQLException {
		Admin admin = new Admin();
		AdminDAO adminDAO = new AdminDAO();
		admin.setUsername("linh");
		admin.setPassword("123456");
		adminDAO.insertAdmin(admin);
		List<Admin> ad = adminDAO.getAllAdmin();
		for(Admin admi : ad ) {
			System.out.println(admi.toString());
		}
	}
}
