package edu.hanu.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CovidData {
	@JsonProperty("last_updated")
	private String lastUpdated;
	@JsonProperty("comfirmed")
	private int confirmed;
	@JsonProperty("deaths")
	private int deaths;
	@JsonProperty("recovered")
	private int recovered;
	@JsonProperty("location")
	private Location location;

}
