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
import edu.hanu.utils.DbUtils;

class CasesDAOTest {
	CasesDAO casesDAO;

	@BeforeEach
	void init() {
		casesDAO = new CasesDAO();
	}

	@Test
	@DisplayName("test select each id")
	void testGet() {
		Cases cases = new Cases("+2", 531, 34, 77713, 82877);
		cases.setId(1);
		assertEquals(cases, casesDAO.get(1));

		Cases cases1 = new Cases("+1900", 100704, 1539, 79914, 209328);
		cases1.setId(2);
		assertEquals(cases1, casesDAO.get(2));

		Cases cases2 = new Cases("+2588", 74234, 2386, 146233, 245567);
		cases2.setId(3);
		assertEquals(cases2, casesDAO.get(3));
	}

	@Test
	@DisplayName("test get all")
	void testGetAll() throws SQLException {
		List<Cases> allCases = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM cases";
		conn = DbUtils.initialise();
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			Cases cases = new Cases();
			cases.setId(rs.getLong("cases_id"));
			cases.setNewCase(rs.getString("new_cases"));
			cases.setActive(rs.getInt("active_case"));
			cases.setCritical(rs.getInt("critical"));
			cases.setRecovered(rs.getInt("recovered"));
			cases.setTotal(rs.getInt("total"));
			allCases.add(cases);
		}
		assertEquals(allCases, casesDAO.getAll());
	}

	@Test
	@DisplayName("test insert")
	void testSave() {

		Cases cases = new Cases(null, 1101930, 16868, 356383, 1550294);
		casesDAO.save(cases);
		cases.setId(454);
		assertEquals(cases, casesDAO.get(454));
	}

	@Test
	@DisplayName("test delete each id ")
	void testDelete() {
		Cases cases = new Cases();
		casesDAO.delete(454);
		assertEquals(cases, casesDAO.get(454));

	}

	@Test

	@DisplayName("test update")
	void testUpdate() {
		Cases cases = new Cases("+2", 531, 344, 77713, 82877);
		cases.setId(1);
		casesDAO.update(cases);

		assertEquals(cases, casesDAO.get(1));

	}
}
