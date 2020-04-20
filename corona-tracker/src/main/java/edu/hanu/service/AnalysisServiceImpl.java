package edu.hanu.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.hanu.model.CovidData;

public class AnalysisServiceImpl implements AnalysisService {
	private List<CovidData> topCovidCountry = null;

	public void setTopCovidCountry() {
		CoronaVirusService<CovidData> coronaService = new CoronaVirusServiceImpl();
		coronaService.setCovidData();
		List<CovidData> covidDatas = coronaService.getCovidData();
		System.out.println(covidDatas.size());
		this.topCovidCountry = covidDatas.subList(2, 8);
	}

	/**
	 * @return the topCovidCountry
	 */
	public List<CovidData> getTopCovidCountry() {
		return topCovidCountry;
	}

	public List<String> getTopCountry() {
		List<String> topCountry = new ArrayList<>();
		topCountry.add("Day");
		for (CovidData c : this.topCovidCountry) {
			topCountry.add(c.getLocation().getCountry());
		}
		return topCountry;
	}

	public String getJsonData() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode chartData = mapper.createObjectNode();
		int count = 0;
		ArrayNode arrayNode = mapper.createArrayNode();

		while (count != this.topCovidCountry.size()) {
			JsonNode node = mapper.createObjectNode();
			for (CovidData c : this.topCovidCountry) {
				((ObjectNode) node).put("Day", c.getDay());
				((ObjectNode) node).put(c.getLocation().getCountry(), c.getCases().getTotal());
			}
			arrayNode.add(node);
			count += 6;
		}
		chartData.set("chartData", arrayNode);
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(chartData);
		return json;
	}
	public static void main(String[] args) {
		AnalysisServiceImpl a = new AnalysisServiceImpl();
		a.setTopCovidCountry();
		try {
			System.out.println(a.getJsonData());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
