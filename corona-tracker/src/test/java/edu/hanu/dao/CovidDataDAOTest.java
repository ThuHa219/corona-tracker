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
import edu.hanu.model.CovidData;
import edu.hanu.model.Death;
import edu.hanu.model.Location;
import edu.hanu.utils.DbUtils;

class CovidDataDAOTest {
	CovidDataDAO covidDataDAO;
	LocationDAO locationDAO;

	@BeforeEach
	void init() {
		covidDataDAO = new CovidDataDAO();
	}

	@Test
	@DisplayName("test select each id")
	void testGet() {
		CasesDAO casesDAO = new CasesDAO();
		DeathDAO deathDAO = new DeathDAO();
		LocationDAO locationDAO = new LocationDAO();
		TestDAO testDAO = new TestDAO();
		CovidData covidData1 = new CovidData();

		Cases cases = casesDAO.get(1);
		Death death = deathDAO.get(1);
		edu.hanu.model.Test test = testDAO.get(1);
		Location location = locationDAO.get(1);

		String day = "2020-05-03";
		String time = "2020-05-03T04:45:04+00:00";

		covidData1.setId(1);
		covidData1.setCases(cases);
		covidData1.setLocation(location);
		covidData1.setDeaths(death);
		covidData1.setTest(test);
		covidData1.setDay(day);
		covidData1.setTime(time);
//		System.out.println(covidData1.toString());
//		System.out.println(covidDataDAO.get(1).toString());
		assertEquals(covidData1, covidDataDAO.get(1));

	}

}
