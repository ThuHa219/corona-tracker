package edu.hanu.service;

import java.util.List;
import java.util.Map;

import edu.hanu.model.CovidData;

public interface AnalysisService {
	
	public void setTopCovidCountry();
	public List<CovidData> getTopCovidCountry();
	public List<String> getTopCountry();
}
