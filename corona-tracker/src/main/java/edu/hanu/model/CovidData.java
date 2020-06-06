package edu.hanu.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@XmlRootElement
public class CovidData {
	
	private String continent;
	private String population;
	@JsonIgnore
	private long id;
	@JsonProperty("country")
	private Location location;
	@JsonProperty("cases")
	private Cases cases;
	@JsonProperty("deaths")
	private Death deaths;
	@JsonProperty("tests")
	private Test test;
	@JsonProperty("day")
	private String day;
	@JsonProperty("time")
	private String time;
	@JsonIgnore
	private List<Link> links = new ArrayList<>();
	
	public void addlink(String uri, String rel) {
		Link link = new Link();
		link.setUri(uri);
		link.setRel(rel);
		links.add(link);
	}
}
