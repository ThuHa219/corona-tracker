package edu.hanu.service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import edu.hanu.dao.AdminDAO;
import edu.hanu.model.Admin;

public class AuthenticationService {
	PasswordAuthentication authentication = new PasswordAuthentication();
	private AdminDAO adminDAO = new AdminDAO();

	@SuppressWarnings({ "static-access", "deprecation" })
	public boolean checkAuthetication(String name, String pass) throws SQLException {
		List<Admin> admins = adminDAO.getAllAdmin();
		List<Admin> result = admins.stream().filter(admin -> admin.getUsername().equals(name))
				.collect(Collectors.toList());
		boolean check = false;
		if (result == null) {
			check = false;
		} else {
			for (Admin admin : result) {
				if (authentication.checkPassword(pass, admin.getPassword()) == true) {
					check = true;
				} else {
					check = false;
				}
			}
		}
		return check;
	}

	public static void main(String[] args) throws SQLException {
		AuthenticationService autheticationService = new AuthenticationService();
		System.out.println(autheticationService.checkAuthetication("chien", "123456"));
	}
}
