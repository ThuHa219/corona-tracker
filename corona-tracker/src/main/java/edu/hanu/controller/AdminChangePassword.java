package edu.hanu.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hanu.model.Admin;
import edu.hanu.service.AdminService;



public class AdminChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminService adminService = new AdminService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("check admin chn");
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/ChangePassword.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("helloAdmin change psw");
		Admin admin = new Admin();
		HttpSession session = request.getSession();
		
		String name = (String) session.getAttribute("name");
		String pass = (String) session.getAttribute("pass");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String cfNewPassword = request.getParameter("cfNewPassword");
		
		admin.setUsername(name);
		if(oldPassword.equals(pass)) {
			if(newPassword.equals(cfNewPassword)) {
				admin.setPassword(newPassword);
				try {
					adminService.changePassword(admin);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher("PatientServlet");
				dispatcher.forward(request, response);
			}
			else {
				request.setAttribute("errorMessage2", "Old passwords are not matched!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/ChangePassword.jsp");
				dispatcher.forward(request, response);
				System.out.println("new psw not the same");
			}
		}else {
			request.setAttribute("errorMessage1", "New passwords are not matched!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/ChangePassword.jsp");
			dispatcher.forward(request, response);
			System.out.println("old psw not the same");
		}
	}

}
