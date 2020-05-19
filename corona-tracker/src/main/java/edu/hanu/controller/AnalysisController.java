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
import edu.hanu.service.InjectionService;

/**
 * Servlet implementation class AnalysisController
 */
public class AnalysisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnalysisService service = new AnalysisServiceImpl(InjectionService.getCacheManager());
		List<CovidData> topCovidCountry = service.getTopCovidCountry();
//		List<String> topCountry = service.getTopCountry();
		request.setAttribute("topCovidCountry", topCovidCountry);
//		request.setAttribute("topCountry", topCountry);
		String path = request.getServletPath();
		if (path.equals("/analysis")) {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/web/analysis.jsp");
		requestDispatcher.forward(request, response);
		} 
		if (path.equals("/analysisDeaths")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/web/analysisDeaths.jsp");
			requestDispatcher.forward(request, response);
		}
		if (path.equals("/analysisRecovered")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/web/analysisRecovered.jsp");
			requestDispatcher.forward(request, response);
		}
		if (path.equals("/analysisTest")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/web/analysisTest.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
