package edu.hanu.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.hanu.dao.CovidDataDAO;
import edu.hanu.dao.TimeUpdatedDAO;
import edu.hanu.model.CovidData;

public class CoronaVirusServiceImpl implements CoronaVirusService {

//	private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	private CacheManager cacheManager;
	private TimeUpdatedDAO timeUpdatedDAO = new TimeUpdatedDAO();

	public CoronaVirusServiceImpl(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

//	public void getCovidUser() throws IOException, InterruptedException {
//		List<CovidUser> covidUsers = new ArrayList<>();
//		HttpClient client = HttpClient.newHttpClient();
//		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(VIRUS_DATA_URL)).build();
//		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//		Reader in = new StringReader(response.body());
//		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
//		for (CSVRecord record : records) {
//			CovidUser covidUser = new CovidUser();
//			covidUser.setProvince(record.get("Province/State"));
//			covidUser.setCountry(record.get("Country/Region"));
//			Coordinate coordinate = new Coordinate();
//			coordinate.setLatitude(record.get("Lat"));
//			coordinate.setLongtitude(record.get("Long"));
//			covidUser.setCoordinate(coordinate);
//			covidUser.setCases(Integer.parseInt(record.get(record.size() - 1)));
//			System.out.println(covidUser.toString());
//			covidUsers.add(covidUser);
//		}
//		this.covidUsers = covidUsers;
//	}
//
//	public List<CovidUser> getLocation() {
//		return this.covidUsers;
//	}

	public List<CovidData> fetchCovidData() throws JsonMappingException, JsonProcessingException {
		Client client = ClientBuilder.newClient();
		WebTarget resourceTarget = client.target("https://covid-193.p.rapidapi.com/statistics");
		Response response = resourceTarget.request(MediaType.APPLICATION_JSON)
				.header("x-rapidapi-host", "covid-193.p.rapidapi.com")
				.header("x-rapidapi-key", "fa40006723msha150e5758ff19a6p1c7c90jsn9512c35ff224").get();
//				.get(String.class);
		String jsonObj = response.readEntity(String.class);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.readValue(jsonObj, ObjectNode.class);
		String json = node.get("response").toString();
		List<CovidData> covidData = mapper.readValue(json, new TypeReference<List<CovidData>>() {
		});
		return covidData;
	}

	public void saveCovidData() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		String todayStr = sdf.format(today);
		if (!InjectionService.checkUpdatedTime(todayStr)) {
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
			timeUpdatedDAO.update(todayStr);
		}
	}

	public List<CovidData> getCovidData() {
//		CovidDataDAO dao = new CovidDataDAO();
//		List<CovidData> covidDatas = dao.getAll();
//		System.out.println("size" + covidDatas.size());
		List<CovidData> covidDataList = null;
		try {
			covidDataList = cacheManager.get("all", new TypeReference<List<CovidData>>() {
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return covidDataList;
	}

//	public List<CovidData> getTopCovidCountry() {
//		List<CovidData> covidDatas = this.covidDatas;
//		return covidDatas.subList(0, 6);
//	}

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		CoronaVirusServiceImpl c = new CoronaVirusServiceImpl(InjectionService.getCacheManager());
		List<CovidData> covidData = c.getCovidData();
		for (CovidData d : covidData) {
			System.out.println(d.toString());
		}
	}
}
