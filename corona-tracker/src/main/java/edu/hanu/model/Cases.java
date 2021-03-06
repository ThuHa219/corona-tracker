package edu.hanu.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@XmlRootElement
public class Cases {
	
	@JsonProperty("1M_pop")
	private String oneMPop;
	@JsonIgnore
	private long id;
	@JsonProperty("new")
	private String newCase;
	@JsonProperty("active")
	private int active;
	@JsonProperty("critical")
	private int critical;
	@JsonProperty("recovered")
	private int recovered;
	@JsonProperty("total")
	private int total;
	
	public Cases(String newCase, int active, int critical, int recovered, int total) {
		super();
		this.newCase = newCase;
		this.active = active;
		this.critical = critical;
		this.recovered = recovered;
		this.total = total;
	}
	
	public Cases() {
		super();
	}
}
