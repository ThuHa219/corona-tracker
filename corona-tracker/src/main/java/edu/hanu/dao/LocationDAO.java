package edu.hanu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.hanu.model.Coordinate;
import edu.hanu.model.Location;
import edu.hanu.utils.DbUtils;

public class LocationDAO implements Dao<Location> {
	private static final String INSERT_SQL_QUERY = "INSERT INTO location(country) VALUES(?)";
	private static final String UPDATE_SQL_QUERY = "UPDATE location SET coordinate_id = ?, country = ? WHERE location.location_id = ?";
	private static final String SELECT_SQL_QUERY = "SELECT * FROM location WHERE location.location_id = ?";
	private static final String SELECT_ALL_SQL_QUERY = "SELECT * FROM location";
	private static final String DELETE_SQL_QUERY = "DELETE FROM location WHERE location.location_id = ?";
	private static final String DELETE_ALL_SQL_QUERY = "DELETE FROM location";
	private CoordinateDAO coordinateDAO = new CoordinateDAO();

	@Override
	public Location get(long id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Location location = new Location();
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("LocationDAO.get: Connection is null");
			}
			ps = conn.prepareStatement(SELECT_SQL_QUERY);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			System.out.println(ps.toString());
			while (rs.next()) {
				location.setId(rs.getLong("location_id"));
				Coordinate coordinate = coordinateDAO.get(rs.getLong("coordinate_id"));
				location.setCoordinate(coordinate);
				location.setCountry(rs.getString("country"));
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
		return location;
	}

	@Override
	public List<Location> getAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Location> locations = new ArrayList<>();
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("LocationDAO.getAll: Connection is null");
			}
			ps = conn.prepareStatement(SELECT_ALL_SQL_QUERY);
			rs = ps.executeQuery();
			System.out.println(ps.toString());
			while (rs.next()) {
				Location location = new Location();
				location.setId(rs.getLong("location_id"));
				Coordinate coordinate = coordinateDAO.get(rs.getLong("coordinate_id"));
				location.setCoordinate(coordinate);
				location.setCountry(rs.getString("country"));
				locations.add(location);
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
		return locations;
	}

	@Override
	public long save(Location t) {
		Connection conn = null;
		PreparedStatement ps = null;
		long id = 0;
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("LocationDAO.save: Connection is null");
			}
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(INSERT_SQL_QUERY, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, t.getCountry());
			ps.execute();
			System.out.println(ps.toString());
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getLong(1);
                t.setId(id);
            }
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
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
	public void update(Location t) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("LocationDAO.update: connection is null");
			}
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(UPDATE_SQL_QUERY);
			ps.setLong(1, t.getCoordinate().getId());
			ps.setString(2, t.getCountry());
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
				throw new NullPointerException("LocationDAO.delete: connection is null");
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
				throw new NullPointerException("LocationDAO.deleteAll: connection is null");
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
