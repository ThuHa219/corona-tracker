package edu.hanu.service;

import java.sql.SQLException;

import edu.hanu.dao.AdminDAO;
import edu.hanu.model.Admin;

public class AdminService {
	private  AdminDAO adminDAO = new AdminDAO();
	 public void changePassword(Admin admin) throws SQLException {
		 adminDAO.updateADmin(admin);
	 }
}
