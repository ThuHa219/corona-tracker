package edu.hanu.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.hanu.dao.CovidDataDAO;
import edu.hanu.dao.TimeUpdatedDAO;

public class InjectionService {
	private static CovidDataDAO covidDataDAO;
	private static CacheManager cacheManager;
	private static TimeUpdatedDAO timeUpdatedDAO = new TimeUpdatedDAO();

	public static CovidDataDAO getCovidDataDAO() {
		if (covidDataDAO == null) {
			covidDataDAO = new CovidDataDAO();
		}
		return covidDataDAO;
	}

	public static CacheManager getCacheManager() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		String todayStr = sdf.format(today);
		if (cacheManager == null || (!checkUpdatedTime(todayStr))) {
			cacheManager = new CacheManager(InjectionService.getCovidDataDAO());
		}
		return cacheManager;
	}

	public static boolean checkUpdatedTime(String currentTime) {
		if (currentTime.equals(timeUpdatedDAO.get(1))) {
			return true;
		} else {
			return false;
		}
	}
}
