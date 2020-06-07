package edu.hanu.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.hanu.model.Cases;
import edu.hanu.model.Coordinate;
import edu.hanu.utils.DbUtils;

class CoordinateDAOTest {

	CoordinateDAO coordinateDAO;

	@BeforeEach
	void init() {
		coordinateDAO = new CoordinateDAO();
	}

	@Test
	@DisplayName("test insert")
	void testSave() {

		Coordinate coordinate = new Coordinate("35.486703", "101.901875");
		coordinateDAO.save(coordinate);
		coordinate.setId(10);
		assertEquals(coordinate, coordinateDAO.get(10));

	}

	@Test
	@DisplayName("test get all")
	void testGetAll() throws SQLException {
		List<Coordinate> coordinates = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM coordinate";
		conn = DbUtils.initialise();
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			Coordinate coordinate = new Coordinate();
			coordinate.setId(rs.getLong("coordinate_id"));
			coordinate.setLatitude(rs.getString("latitude"));
			coordinate.setLongtitude(rs.getString("longtitude"));
			coordinates.add(coordinate);
		}
		assertEquals(coordinates, coordinateDAO.getAll());
	}

	@Test
	@DisplayName("test delete each id ")
	void testDelete() {
		Coordinate coordinate = new Coordinate();
		coordinateDAO.delete(1);
		assertEquals(coordinate, coordinateDAO.get(1));

	}

	@Test

	@DisplayName("test update")
	void testUpdate() {
		Coordinate coordinate = new Coordinate("35.486703", "101.901875");
		coordinate.setId(3);
		coordinateDAO.update(coordinate);

		assertEquals(coordinate, coordinateDAO.get(3));

	}
}
