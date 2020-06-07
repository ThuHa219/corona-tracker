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
import edu.hanu.model.Death;
import edu.hanu.utils.DbUtils;

class DeathDAOTest {
	DeathDAO deathDAO;// tao object

	@BeforeEach // trc moi method object co the bien doi nen tao de co the o nguyen ban
	void init() {
		deathDAO = new DeathDAO();
	}

	@Test // test tung method trong class to DeathDAO
	@DisplayName("test select each id")
	void testGet() { // test luon trc method phia sau
		Death death = new Death("+474", 28710);
		death.setId(2);
		assertEquals(death, deathDAO.get(2));// method nay so sanh giua expect va real value

		Death death1 = new Death(null, 250);
		death1.setId(8);
		assertEquals(death1, deathDAO.get(8));

		Death death2 = new Death("+8", 1762);
		death2.setId(9);
		assertEquals(death2, deathDAO.get(9));

		Death death3 = new Death();
		assertEquals(death3, deathDAO.get(500));

	}

	@Test
	@DisplayName("test get all")
	void testGetAll() throws SQLException {
		List<Death> deaths = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM death";
		conn = DbUtils.initialise();
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			Death death = new Death();
			death.setId(rs.getLong("death_id"));
			death.setNewDeath(rs.getString("new_death"));
			death.setTotal(rs.getInt("total"));
			deaths.add(death);
		}
		assertEquals(deaths, deathDAO.getAll());
	}

	@Test
	@DisplayName("test insert")
	void testSave() {

		Death death = new Death("+474", 28710);
		deathDAO.save(death);
		death.setId(458);
		assertEquals(death, deathDAO.get(458));
	}

	@Test
	@DisplayName("test delete each id ")
	void testDelete() {
		Death death = new Death();
		deathDAO.delete(458);
		assertEquals(death, deathDAO.get(458));

	}

	@Test
	@DisplayName("test update")
	void testUpdate() {
		Death death = new Death("+474", 287101);
		death.setId(457);
		deathDAO.update(death);

		assertEquals(death, deathDAO.get(457));

	}
}
