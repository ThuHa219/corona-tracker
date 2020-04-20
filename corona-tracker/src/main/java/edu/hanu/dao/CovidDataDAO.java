package edu.hanu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import edu.hanu.model.Cases;
import edu.hanu.model.CovidData;
import edu.hanu.model.Death;
import edu.hanu.utils.DbUtils;

public class CovidDataDAO implements Dao<CovidData> {
	private static final String INSERT_SQL_QUERY = "INSERT INTO covid_data(location_id, cases_id, death_id, test_id, day_updated, time_updated) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_SQL_QUERY = "UPDATE covid_data SET location_id = ?, cases_id = ?, death_id = ?, test_id = ?, day_updated = ?, time_updated = ? WHERE covid_data.covid_data_id = ?";
	private static final String SELECT_SQL_QUERY = "SELECT * FROM covid_data WHERE covid_data.covid_data_id = ?";
	private static final String SELECT_ALL_SQL_QUERY = "SELECT * FROM covid_data";
	private static final String DELETE_SQL_QUERY = "DELETE FROM covid_data WHERE covid_data.covid_data_id = ?";
	private static final String DELETE_ALL_SQL_QUERY = "DELETE FROM covid_data";
	private static final String SELECT_LATEST_QUERY = "SELECT * FROM (SELECT * FROM covid_data ORDER BY covid_data_id DESC LIMIT 217) AS T ORDER BY covid_data_id ASC;";

	private LocationDAO locationDAO = new LocationDAO();
	private CasesDAO casesDAO = new CasesDAO();
	private DeathDAO deathDAO = new DeathDAO();
	private TestDAO testDAO = new TestDAO();

	@Override
	public CovidData get(long id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CovidData covidData = new CovidData();
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("CovidDataDAO.get: Connection is null");
			}
			ps = conn.prepareStatement(SELECT_SQL_QUERY);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			System.out.println(ps.toString());
			while (rs.next()) {
				covidData.setId(rs.getLong("covid_data_id"));
				covidData.setLocation(locationDAO.get(rs.getLong("location_id")));
				covidData.setCases(casesDAO.get(rs.getLong("cases_id")));
				covidData.setDeaths(deathDAO.get(rs.getLong("death_id")));
				covidData.setTest(testDAO.get(rs.getLong("test_id")));
				covidData.setDay(rs.getString("day_updated"));
				covidData.setTime(rs.getString("time_updated"));
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
		return covidData;
	}

	@Override
	public List<CovidData> getAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CovidData> covidDatas = new ArrayList<>();
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("CovidDataDAO.getAll: Connection is null");
			}
			ps = conn.prepareStatement(SELECT_ALL_SQL_QUERY);
			rs = ps.executeQuery();
			System.out.println(ps.toString());
			while (rs.next()) {
				CovidData covidData = new CovidData();
				covidData.setId(rs.getLong("covid_data_id"));
				covidData.setLocation(locationDAO.get(rs.getLong("location_id")));
				covidData.setCases(casesDAO.get(rs.getLong("cases_id")));
				covidData.setDeaths(deathDAO.get(rs.getLong("death_id")));
				covidData.setTest(testDAO.get(rs.getLong("test_id")));
				covidData.setDay(rs.getString("day_updated"));
				covidData.setTime(rs.getString("time_updated"));
				covidDatas.add(covidData);
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
		return covidDatas;

	}

	@Override
	public long save(CovidData t) {
		Connection conn = null;
		PreparedStatement ps = null;
		long id = 0;
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("CovidDataDAO.save: Connection is null");
			}
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(INSERT_SQL_QUERY, Statement.RETURN_GENERATED_KEYS);
			locationDAO.save(t.getLocation());
			ps.setLong(1, t.getLocation().getId());
			casesDAO.save(t.getCases());
			ps.setLong(2, t.getCases().getId());
			deathDAO.save(t.getDeaths());
			ps.setLong(3, t.getDeaths().getId());
			testDAO.save(t.getTest());
			ps.setLong(4, t.getTest().getId());
			ps.setString(5, t.getDay());
			ps.setString(6, t.getTime());
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
	public void update(CovidData t) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("CovidDataDAO.update: connection is null");
			}
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(UPDATE_SQL_QUERY);
			ps.setLong(1, t.getLocation().getId());
			ps.setLong(2, t.getCases().getId());
			ps.setLong(3, t.getDeaths().getId());
			ps.setLong(4, t.getTest().getId());
			ps.setString(5, t.getDay());
			ps.setString(6, t.getTime());
			ps.setLong(7, t.getId());
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
				throw new NullPointerException("CovidDataDAO.delete: connection is null");
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

	private List<CovidData> getLatestData() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CovidData> covidDatas = new ArrayList<>();
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("CovidDataDAO.getAll: Connection is null");
			}
			ps = conn.prepareStatement(SELECT_LATEST_QUERY);
			rs = ps.executeQuery();
			System.out.println(ps.toString());
			while (rs.next()) {
				CovidData covidData = new CovidData();
				covidData.setId(rs.getLong("covid_data_id"));
				covidData.setLocation(locationDAO.get(rs.getLong("location_id")));
				covidData.setCases(casesDAO.get(rs.getLong("cases_id")));
				covidData.setDeaths(deathDAO.get(rs.getLong("death_id")));
				covidData.setTest(testDAO.get(rs.getLong("test_id")));
				covidData.setDay(rs.getString("day_updated"));
				covidData.setTime(rs.getString("time_updated"));
				covidDatas.add(covidData);
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
		return covidDatas;
	}
	
	public static void main(String[] args) {
		CovidDataDAO dao = new CovidDataDAO();
		List<CovidData> covidData = dao.getAll();
		for (CovidData l : covidData) {
			System.out.println(l.toString());
		}

	}
}
