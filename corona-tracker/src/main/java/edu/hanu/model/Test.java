package edu.hanu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Test {
	@JsonIgnore
	private long id;
	private int total;
}
