package edu.hanu.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.hanu.model.Patient;
import edu.hanu.service.PatientService;

public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientService patientService = new PatientService();
	public PatientServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/admin/add")) {
			RequestDispatcher rd = request.getRequestDispatcher("/view/admin/add-patient.jsp");
			request.setAttribute("path", path);
			rd.forward(request, response);
		}
		if (path.equals("/admin/edit")) {
			RequestDispatcher rd = request.getRequestDispatcher("/view/admin/edit-patient.jsp");
			request.setAttribute("path", path);
			rd.forward(request, response);
		}
		if (path.equals("/admin/delete")) {
			System.out.println(request.getParameter("patientId"));
			try {
				patientService.deletePatient(request.getParameter("patientId"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("PatientServlet");
			rd.forward(request, response);
		}
		System.out.println(path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/admin/edit")) {
			edit(request, response);
		} else if (path.equals("/admin/add")) {
			add(request, response);
		}
		System.out.println(path);
	}

	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Patient patient = new Patient();
		patient.setPatientId(request.getParameter("patientId"));
		int age = Integer.parseInt(request.getParameter("age"));
		patient.setAge(age);
		patient.setGender(request.getParameter("gender"));
		patient.setNationality(request.getParameter("patientNationality"));
		patient.setAddress(request.getParameter("patientAddress"));
		patient.setPatientStatus(request.getParameter("patientStatus"));
		patient.setPatientDescription(request.getParameter("description"));
		try {
			patientService.editPatient(patient);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("PatientServlet");
		rd.forward(request, response);
	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PatientService patientService = new PatientService();
		String id = request.getParameter("patientId");
		System.out.println(id);
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String nationality = request.getParameter("patientNationality");
		System.out.println(nationality);
		String address = request.getParameter("patientAddress");
		String status = request.getParameter("patientStatus");
		String description = request.getParameter("desription");
		Patient patient = new Patient();
		patient.setPatientId(id);
		patient.setAge(age);
		patient.setGender(gender);
		patient.setNationality(nationality);
		patient.setAddress(address);
		patient.setPatientStatus(status);
		patient.setPatientDescription(description);
		try {
			patientService.addPatient(patient);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("PatientServlet");
		rd.forward(request, response);
	}
}
