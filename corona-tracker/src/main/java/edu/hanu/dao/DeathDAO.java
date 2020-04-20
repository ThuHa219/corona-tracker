package edu.hanu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.hanu.model.Death;
import edu.hanu.utils.DbUtils;

public class DeathDAO implements Dao<Death> {
	private static final String INSERT_SQL_QUERY = "INSERT INTO death(new_death, total) VALUES(?, ?)";
	private static final String UPDATE_SQL_QUERY = "UPDATE death SET new_death = ?, total = ? WHERE death.death_id = ?";
	private static final String SELECT_SQL_QUERY = "SELECT * FROM death WHERE death.death_id = ?";
	private static final String SELECT_ALL_SQL_QUERY = "SELECT * FROM death";
	private static final String DELETE_SQL_QUERY = "DELETE FROM death WHERE death.death_id = ?";
	private static final String DELETE_ALL_SQL_QUERY = "DELETE FROM death";

	@Override
	public Death get(long id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Death death = new Death();
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("DeathDAO.get: connection is null");
			}
			ps = conn.prepareStatement(SELECT_SQL_QUERY);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			System.out.println(ps.toString());
			while (rs.next()) {
				death.setId(rs.getLong("death_id"));
				death.setNewDeath(rs.getString("new_death"));
				death.setTotal(rs.getInt("total"));
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
		return death;
	}

	@Override
	public List<Death> getAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Death> deaths = new ArrayList<>();
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("DeathDAO.getAll: connection is null");
			}
			ps = conn.prepareStatement(SELECT_ALL_SQL_QUERY);
			rs = ps.executeQuery();
			System.out.println(ps.toString());
			while (rs.next()) {
				Death death = new Death();
				death.setId(rs.getLong("death_id"));
				death.setNewDeath(rs.getString("new_death"));
				death.setTotal(rs.getInt("total"));
				deaths.add(death);
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
		return deaths;
	}

	@Override
	public long save(Death t) {
		Connection conn = null;
		PreparedStatement ps = null;
		long id = 0;
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("DeathDAO.save: connection is null");
			}
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(INSERT_SQL_QUERY, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, t.getNewDeath());
			ps.setInt(2, t.getTotal());

			ps.execute();
			System.out.println(ps.toString());
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getLong(1);
				t.setId(id);
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				DbUtils.closePreparedStatement(ps);
				DbUtils.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}

	@Override
	public void update(Death t) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("DeathDAO.update: connection is null");
			}
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(UPDATE_SQL_QUERY);
			ps.setString(1, t.getNewDeath());
			ps.setInt(2, t.getTotal());
			ps.setLong(3, t.getId());
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

	@Override
	public void delete(long id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("DeathDAO.delete: connection is null");
			}
			ps = conn.prepareStatement(DELETE_SQL_QUERY);
			ps.setLong(1, id);
			ps.execute();
			System.out.println(ps.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.closePreparedStatement(ps);
				DbUtils.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void deleteAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("DeathDAO.deleteAll: connection is null");
			}
			ps = conn.prepareStatement(DELETE_ALL_SQL_QUERY);
			ps.execute();
			System.out.println(ps.toString());
		} catch (SQLException e) {
			e.printStackTrace();
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
