package edu.hanu.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CovidData {
	
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
}
