package edu.hanu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.hanu.model.Coordinate;
import edu.hanu.utils.DbUtils;

public class CoordinateDAO implements Dao<Coordinate> {
	private static final String INSERT_SQL_QUERY = "INSERT INTO coordinate(latitude, longtitude) VALUES(?, ?)";
	private static final String UPDATE_SQL_QUERY = "UPDATE coordinate SET latitude = ?, longtitude = ? WHERE cooordinate.coordinate_id = ?";
	private static final String SELECT_SQL_QUERY = "SELECT * FROM coordinate WHERE coordinate.coordinate_id = ?";
	private static final String SELECT_ALL_SQL_QUERY = "SELECT * FROM coordinate";
	private static final String DELETE_SQL_QUERY = "DELETE FROM coordinate WHERE coordinate.coordinate_id = ?";
	private static final String DELETE_ALL_SQL_QUERY = "DELETE FROM coordinate";

	@Override
	public Coordinate get(long id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Coordinate coordinate = new Coordinate();

		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("CoordinateDAO.get: Connection is null");
			}
			ps = conn.prepareStatement(SELECT_SQL_QUERY);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			System.out.println(ps.toString());
			while (rs.next()) {
				coordinate.setId(rs.getLong("coordinate_id"));
				coordinate.setLatitude(rs.getString("latitude"));
				coordinate.setLongtitude(rs.getString("longtitude"));
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
		return coordinate;
	}

	@Override
	public List<Coordinate> getAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Coordinate> coordinates = new ArrayList<>();
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("CoordinateDAO.getAll: Connection is null");
			}
			ps = conn.prepareStatement(SELECT_ALL_SQL_QUERY);
			rs = ps.executeQuery();
			System.out.println(ps.toString());
			while (rs.next()) {
				Coordinate coordinate = new Coordinate();
				coordinate.setId(rs.getLong("coordinate_id"));
				coordinate.setLatitude(rs.getString("latitude"));
				coordinate.setLongtitude(rs.getString("longtitude"));
				coordinates.add(coordinate);
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
		return coordinates;
	}

	@Override
	public long save(Coordinate t) {
		Connection conn = null;
		PreparedStatement ps = null;
		long id = 0;
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("CoordinateDAO.save: Connection is null");
			}
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(INSERT_SQL_QUERY, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, t.getLatitude());
			ps.setString(2, t.getLongtitude());
			ps.execute();
			System.out.println(ps.toString());
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if(generatedKeys.next()) {
				id = generatedKeys.getLong(1);
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
	public void update(Coordinate t) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("CoordinateDAO.update: Connection is null");
			}
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(UPDATE_SQL_QUERY);
			ps.setString(1, t.getLatitude());
			ps.setString(2, t.getLongtitude());
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
				throw new NullPointerException("CoordinateDAO.delete: Connection is null");
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
				throw new NullPointerException("CoordinateDAO.deleteAll: Connection is null");
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
