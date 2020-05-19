package edu.hanu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.hanu.utils.DbUtils;

public class TimeUpdatedDAO {
	private static final String UPDATE_SQL_QUERY = "UPDATE time_updated SET time_updated = ? WHERE time_updated.time_updated_id = ?";
	private static final String SELECT_SQL_QUERY = "SELECT * FROM time_updated WHERE time_updated.time_updated_id = ?";

	public String get(long id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String timeUpdated = null;

		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("TimeUpdatedDAO.get: Connection is null");
			}
			ps = conn.prepareStatement(SELECT_SQL_QUERY);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			System.out.println(ps.toString());
			while (rs.next()) {
				timeUpdated = rs.getString("time_updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.closeResultSet(rs);
				DbUtils.closePreparedStatement(ps);
				DbUtils.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return timeUpdated;
	}

	public void update(String timeUpdated) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("TimeUpdatedDAO.update: Connection is null");
			}
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(UPDATE_SQL_QUERY);
			ps.setString(1, timeUpdated);
			ps.setLong(2, 1);
			ps.execute();
			System.out.println(ps.toString());
			conn.commit();
		} catch (SQLException e) {
			try {
				if (conn != null) {
					conn.rollback();
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				DbUtils.closePreparedStatement(ps);
				DbUtils.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
