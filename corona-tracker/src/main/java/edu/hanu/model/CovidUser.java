package edu.hanu.model;

import java.util.Date;

import lombok.Data;

@Data
public class CovidUser {
	
	private int age;
	private String gender;
	private Date symptomOnset;
	private Date hospVisitDate;
	private Date exposureStart;
	private Date reportDate;
	private boolean death;
	private String symptom;
}
