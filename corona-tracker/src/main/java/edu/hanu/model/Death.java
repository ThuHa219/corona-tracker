package edu.hanu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Death {
	
	@JsonIgnore
	private long id;
	@JsonProperty("new")
	private String newDeath;
	@JsonProperty("total")
	private int total;
	
	public Death(String newDeath, int total) {
		super();
		this.newDeath = newDeath;
		this.total = total;
	}

	public Death() {
		super();
	}
}
