package edu.hanu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hanu.model.CovidData;
import edu.hanu.model.CovidUser;
import edu.hanu.model.Location;
import edu.hanu.service.CoronaVirusService;
import edu.hanu.service.CoronaVirusServiceImpl;

public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CoronaVirusServiceImpl coronaService = new CoronaVirusServiceImpl();
		coronaService.setCovidData();
		List<CovidData> covidData = coronaService.getCovidData();
		for (CovidData l : covidData) {
			System.out.println(l.toString());
		}
		System.out.println(covidData.size());
//		int totalCases = covidData.stream().mapToInt(cases -> cases.getCases().getTotal()).sum();
		request.setAttribute("covidData", covidData);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/web/home.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
