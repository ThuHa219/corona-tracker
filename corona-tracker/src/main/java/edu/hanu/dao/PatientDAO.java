package edu.hanu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.hanu.model.Patient;
import edu.hanu.utils.DbUtils;


public class PatientDAO {
	private static final String INSERT_QUERRY = "INSERT INTO patient_info VALUES(now(),?,?,?,?,?,?,?)";
	private static final String SELECT_ALL_QUERRY = "SELECT * FROM patient_info";
	private static final String SELECT_PATIENT_QUERRY = "SELECT * FROM patient_info WHERE patient_id=?";
	private static final String UPDATE_PATIENT_QUERRY = "UPDATE patient_info SET age=?, gender=?, nationality=?, address=?, patient_status=?,patient_decription=? WHERE patient_id= ?";
	private static final String DELETE_PATIENT_QUERRY = "DELETE FROM patient_info WHERE patient_id= ?";
	private static final String DELETE_ALL_PATIENT_QUERRY = "DELETE FROM patient_info";

	public void insertPatient(Patient patient) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("PatientInfoDAO.insertPatient: Connection is null !");
			}
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(INSERT_QUERRY);
			ps.setString(1, patient.getPatientId());
			ps.setInt(2, patient.getAge());
			ps.setString(3, patient.getGender());
			ps.setString(4, patient.getNationality());
			ps.setString(5, patient.getAddress());
			ps.setString(6, patient.getPatientStatus());
			ps.setString(7, patient.getPatientDescription());
			ps.execute();
			System.out.println(ps.toString());
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtils.closeConnection(conn);
			DbUtils.closePreparedStatement(ps);
		}
	}

	public List<Patient> getAllPatient() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Patient> patients = new ArrayList<>();
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("PatientInfoDAO.getAllPatient: Connection is null");
			}
			ps = conn.prepareStatement(SELECT_ALL_QUERRY);
			rs = ps.executeQuery();
			System.out.println(ps.toString());
			while (rs.next()) {
				Patient patient = new Patient();
				patient.setTimeUpdate(rs.getString("time_update"));
				patient.setPatientId(rs.getString("patient_id"));
				patient.setAge(rs.getInt("age"));
				patient.setGender(rs.getString("gender"));
				patient.setNationality(rs.getString("nationality"));
				patient.setAddress(rs.getString("address"));
				patient.setPatientStatus(rs.getString("patient_status"));
				patient.setPatientDescription(rs.getString("patient_decription"));
				patients.add(patient);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			// mo cai gicuoi cung thi dong lai dau tien
			DbUtils.closeResultSet(rs);
			DbUtils.closePreparedStatement(ps);
			DbUtils.closeConnection(conn);
		}
		return patients;
	}

	public  Patient getPatient(String patientId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Patient  patient = new Patient();
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("PatientInfoDAO.getPatient: Connection is null");
			}
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(SELECT_PATIENT_QUERRY);
			ps.setString(1, patientId);
			rs = ps.executeQuery();
			System.out.println(ps.toString());
			conn.commit();
			while (rs.next()) {
				patient.setTimeUpdate(rs.getString("time_update"));
				patient.setPatientId(rs.getString("patient_id"));
				patient.setAge(rs.getInt("age"));
				patient.setGender(rs.getString("gender"));
				patient.setNationality(rs.getString("nationality"));
				patient.setAddress(rs.getString("address"));
				patient.setPatientStatus(rs.getString("patient_status"));
				patient.setPatientDescription(rs.getString("patient_decription"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeResultSet(rs);
			DbUtils.closePreparedStatement(ps);
			DbUtils.closeConnection(conn);
		}
		return patient;
	}

	public void updatePatient(Patient patient) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("PatientInfoDao.updatePatient: Connection is null");
			}
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(UPDATE_PATIENT_QUERRY);
			ps.setInt(1, patient.getAge());
			ps.setString(2, patient.getGender());
			ps.setString(3, patient.getNationality());
			ps.setString(4, patient.getAddress());
			ps.setString(5, patient.getPatientStatus());
			ps.setString(6, patient.getPatientDescription());
			ps.setString(7, patient.getPatientId());
			ps.execute();
			System.out.println(ps.toString());
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtils.closePreparedStatement(ps);
			DbUtils.closeConnection(conn);
		}
	}

	public void deletePatient(String patientID) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("PatientInfoDAO.deletePatient: Connection is null ! ");
			}
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(DELETE_PATIENT_QUERRY);
			ps.setString(1,patientID);
			ps.execute();
			System.out.println(ps.toString());
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtils.closePreparedStatement(ps);
			DbUtils.closeConnection(conn);
		}
	}

	public static void deleteAllPatient() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtils.initialise();
			if (conn == null) {
				throw new NullPointerException("PatientInfoDAO.deleteAllPatient: Connecton is null !");
			}
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(DELETE_ALL_PATIENT_QUERRY);
			ps.execute();
			System.out.println(ps.toString());
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DbUtils.closePreparedStatement(ps);
			DbUtils.closeConnection(conn);
		}
	}
	
	public static void main(String[] args) throws SQLException {
		PatientDAO dao =new PatientDAO();
		//Patient patient = new Patient();
//		patient.setAddress("QN");
//		patient.setAge(55);
//		patient.setGender("Male");
//		patient.setNationality("VN");
//		patient.setPatientDecription("Ngu vlll");
//		patient.setPatientId("BN211");
//		patient.setPatientStatus("On the bed");
		
		//dao.insertPatient(patient);
		List<Patient> patients = dao.getAllPatient();
		for(Patient p : patients) {
			System.out.println(p.toString());
		}
	}

}
