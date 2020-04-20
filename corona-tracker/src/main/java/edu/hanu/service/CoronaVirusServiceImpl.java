package edu.hanu.service;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.hanu.dao.CovidDataDAO;
import edu.hanu.model.Coordinate;
import edu.hanu.model.CovidData;
import edu.hanu.model.CovidUser;

public class CoronaVirusServiceImpl implements CoronaVirusService {

	private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	private List<CovidUser> covidUsers = new ArrayList<>();
	private List<CovidData> covidDatas = null;

	public void getCovidUser() throws IOException, InterruptedException {
		List<CovidUser> covidUsers = new ArrayList<>();
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(VIRUS_DATA_URL)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		Reader in = new StringReader(response.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
		for (CSVRecord record : records) {
			CovidUser covidUser = new CovidUser();
			covidUser.setProvince(record.get("Province/State"));
			covidUser.setCountry(record.get("Country/Region"));
			Coordinate coordinate = new Coordinate();
			coordinate.setLatitude(record.get("Lat"));
			coordinate.setLongtitude(record.get("Long"));
			covidUser.setCoordinate(coordinate);
			covidUser.setCases(Integer.parseInt(record.get(record.size() - 1)));
			System.out.println(covidUser.toString());
			covidUsers.add(covidUser);
		}
		this.covidUsers = covidUsers;
	}

	public List<CovidUser> getLocation() {
		return this.covidUsers;
	}

	public List<CovidData> fetchCovidData() throws JsonMappingException, JsonProcessingException {
		Client client = ClientBuilder.newClient();
		WebTarget resourceTarget = client.target("https://covid-193.p.rapidapi.com/statistics");
		String jsonObj = resourceTarget.request(MediaType.APPLICATION_JSON)
				.header("x-rapidapi-host", "covid-193.p.rapidapi.com")
				.header("x-rapidapi-key", "fa40006723msha150e5758ff19a6p1c7c90jsn9512c35ff224").get(String.class);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.readValue(jsonObj, ObjectNode.class);
		String json = node.get("response").toString();
		List<CovidData> covidData = mapper.readValue(json, new TypeReference<List<CovidData>>() {
		});
		return covidData;
	}
	
	public void saveCovidData() {
		CovidDataDAO dao = new CovidDataDAO();
		List<CovidData> covidData = null;
		try {
			covidData = fetchCovidData();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (CovidData d : covidData) {
			dao.save(d);
		}
	}
	
	public void setCovidData() {
		CovidDataDAO dao = new CovidDataDAO();
		List<CovidData> covidDatas = dao.getAll();
		System.out.println("size" + covidDatas.size());
		covidDatas.sort((a, b)->b.getCases().getTotal() - a.getCases().getTotal());
		this.covidDatas = covidDatas;
	}
	
	public List<CovidData> getTopCovidCountry() {
		List<CovidData> covidDatas = this.covidDatas;
		return covidDatas.subList(0, 6);
	}

	/**
	 * @return the covidDatas
	 */
	public List<CovidData> getCovidData() {
		return this.covidDatas;
	}

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		CoronaVirusServiceImpl c = new CoronaVirusServiceImpl();
		CovidDataDAO dao = new CovidDataDAO();
		List<CovidData> covidData = c.getCovidData();
		for (CovidData d : covidData) {
			d.toString();
		}
	}
}
