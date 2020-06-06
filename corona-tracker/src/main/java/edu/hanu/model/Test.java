package edu.hanu.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@XmlRootElement
public class Test {
	
	@JsonProperty("1M_pop")
	private String oneMPop;
	@JsonIgnore
	private long id;
	private int total;
}
