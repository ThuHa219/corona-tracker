package edu.hanu.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.hanu.model.Cases;
import edu.hanu.utils.DbUtils;

class TestDAOTest {

	TestDAO testDAO;

	@BeforeEach
	void init() {
		testDAO = new TestDAO();
	}

	@Test
	@DisplayName("test select each id")
	void testGet() {
		edu.hanu.model.Test test = new edu.hanu.model.Test();
		test.setId(2);
		test.setTotal(2108837);
		assertEquals(test, testDAO.get(2));
	}

	@Test
	@DisplayName("test insert")
	void testSave() {

		edu.hanu.model.Test test = new edu.hanu.model.Test();
		testDAO.save(test);
		test.setId(454);
		assertEquals(test, testDAO.get(454));
	}

	@Test

	@DisplayName("test update")
	void testUpdate() {
		edu.hanu.model.Test test = new edu.hanu.model.Test();
		test.setId(451);
		test.setTotal(1);
		testDAO.update(test);

		assertEquals(test, testDAO.get(451));

	}
}
