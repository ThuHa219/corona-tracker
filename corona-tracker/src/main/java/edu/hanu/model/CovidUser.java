package edu.hanu.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@SuppressWarnings("notused")
public class CovidUser {
	
	@JsonProperty("coordinate")
	private Coordinate coordinate;
	@JsonProperty("province")
	private String province;
	@JsonProperty("country")
	private String country;
	@JsonProperty("cases_today")
	private int cases;
	@Override
	public String toString() {
		return "CovidUser [coordinate=" + coordinate + ", province=" + province + ", country=" + country + ", cases="
				+ cases + "]";
	}
}
