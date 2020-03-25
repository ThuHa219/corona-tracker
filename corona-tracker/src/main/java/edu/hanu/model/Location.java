package edu.hanu.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Location {

	@JsonProperty("coordinate")
	private Coordinate coordinate;
	@JsonProperty("province")
	private String province;
	@JsonProperty("country")
	private String country;
}
