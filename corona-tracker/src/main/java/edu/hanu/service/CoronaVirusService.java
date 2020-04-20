package edu.hanu.service;

import java.util.List;

public interface CoronaVirusService<E> {
	List<E> getCovidData();
	public List<E> getTopCovidCountry();
	public void setCovidData();
}
