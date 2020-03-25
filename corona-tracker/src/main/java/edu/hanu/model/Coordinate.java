package edu.hanu.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Coordinate {

	@JsonProperty("lat")
	private String latitude;
	@JsonProperty("long")
	private String longtitude;

	public Coordinate(String latitude, String longtitude) {
		super();
		this.latitude = latitude;
		this.longtitude = longtitude;
	}

	public Coordinate() {
		super();
	}
}
