package edu.hanu.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class Coordinate {
	
	private long id;
	private String latitude;
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
