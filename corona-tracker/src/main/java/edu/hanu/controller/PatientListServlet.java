package edu.hanu.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.hanu.model.Patient;
import edu.hanu.service.PatientService;

/**
 * Servlet implementation class PatientServlet
 */
public class PatientListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doGet(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PatientService patientService = new PatientService();
		List<Patient> listPatient = null;
		String path = request.getServletPath();
		try {
			listPatient = patientService.getAllPatient();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listPatient", listPatient);
		if (path.equals("/timeline")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/web/timeline.jsp");
			dispatcher.forward(request, response);
		} else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/PatientList.jsp");
		dispatcher.forward(request, response);
		}
	}
}
