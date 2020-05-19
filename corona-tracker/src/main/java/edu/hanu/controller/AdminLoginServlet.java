package edu.hanu.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.hanu.service.AuthenticationService;

/**
 * Servlet implementation class Login
 */

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		AuthenticationService authenticationService = new AuthenticationService();
		try {
			if (authenticationService.checkAuthetication(name, pass)) {
				HttpSession session = request.getSession();
				session.setAttribute("name", name);
				session.setAttribute("pass", pass);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/PatientServlet");
				dispatcher.forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.invalidate();
				request.setAttribute("errorMessage", "Invalid username or password");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/login.jsp");
				dispatcher.forward(request, response);
				System.out.println("Failed");
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}