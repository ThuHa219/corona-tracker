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
import edu.hanu.model.Patient;
import edu.hanu.utils.DbUtils;

class PatientDAOTest {

	PatientDAO patientDAO;

	@BeforeEach
	void init() {
		patientDAO = new PatientDAO();
	}

	@Test
	@DisplayName("test select each id")
	void testGet() {
		Patient patient = new Patient("2020-04-28 14:06:16", "BN16", 50, "Male", "Vietnamese", "Vinh Phuc", "Recovered",
				"Father of BN05.");

		try {
			assertEquals(patient.toString(), patientDAO.getPatient("BN16").toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("test delete each id ")
	void testDelete() throws SQLException {
		Patient patient = new Patient();
		patientDAO.deletePatient("BN03");
		assertEquals(patient.toString(), patientDAO.getPatient("BN03").toString());

	}

	@Test

	@DisplayName("test update")
	void testUpdate() throws SQLException {
		Patient patient = new Patient("2020-04-13 19:18:21", "BN02", 288, "Male", "Chinese", "TP HCM", "Recovered",
				"Son of BN01");

		patientDAO.updatePatient(patient);

		assertEquals(patient.toString(), patientDAO.getPatient("BN02").toString());

	}

}