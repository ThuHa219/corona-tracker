package edu.hanu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hanu.dao.PatientDAO;
import edu.hanu.model.Patient;

public class PatientService {
	PatientDAO patientDAO = new PatientDAO();
	
	public List<Patient> getAllPatient() throws SQLException{
		List<Patient> listPatient = patientDAO.getAllPatient();
		return listPatient;
	}
	
	public void addPatient(Patient patient) throws SQLException{
		patientDAO.insertPatient(patient);
	}
	
	public void editPatient(Patient patient) throws SQLException {
		patientDAO.updatePatient(patient);
	}
	
	public void deletePatient(String patientID) throws SQLException {
		patientDAO.deletePatient(patientID);
	}
	
}
