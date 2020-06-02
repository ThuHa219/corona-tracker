package edu.hanu.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@XmlRootElement
public class Test {
	@JsonIgnore
	private long id;
	private int total;
}
