package edu.hanu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hanu.model.CovidData;
import edu.hanu.service.AnalysisService;
import edu.hanu.service.AnalysisServiceImpl;

/**
 * Servlet implementation class AnalysisController
 */
public class AnalysisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnalysisService service = new AnalysisServiceImpl();
		service.setTopCovidCountry();
		List<CovidData> topCovidCountry = service.getTopCovidCountry();
		List<String> topCountry = service.getTopCountry();
		request.setAttribute("topCovidCountry", topCovidCountry);
		request.setAttribute("topCountry", topCountry);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/web/analysis.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
