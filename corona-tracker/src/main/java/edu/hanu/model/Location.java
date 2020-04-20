package edu.hanu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Location {
	
	@JsonIgnore
	private long id;
	@JsonIgnore
	private Coordinate coordinate;
	@JsonProperty("country")
	private String country;

	public Location(String country) {
		super();
		this.country = country;
	}
	
	public Location() {
		//do nothing
	}
}
