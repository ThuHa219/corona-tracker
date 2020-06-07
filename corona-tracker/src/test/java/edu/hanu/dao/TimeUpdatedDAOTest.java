package edu.hanu.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.hanu.model.Cases;

class TimeUpdatedDAOTest {

	TimeUpdatedDAO timeUpdatedDAO;

	@BeforeEach
	void init() {
		timeUpdatedDAO = new TimeUpdatedDAO();
	}

	@Test
	@DisplayName("test select each id")
	void testGet() {
		String timeUpdated = "2020-05-19";

		assertEquals(timeUpdated, timeUpdatedDAO.get(1));

	}

	void testUpdate() {
		String timeUpdated = "2020-05-20";

		assertEquals(timeUpdated, timeUpdatedDAO.get(1));

	}
}
