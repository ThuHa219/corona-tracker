package edu.hanu.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Patient {
	private String timeUpdate;
	private String patientId;
	private int age;
	private String gender;
	private String nationality;
	private String address;
	private String patientStatus;
	private String patientDescription;
	public Patient(String timeUpdate, String patientId, int age, String gender, String nationality,
			String address, String patientStatus, String patientDescription) {
		super();
		this.timeUpdate = timeUpdate;
		this.patientId = patientId;
		this.age = age;
		this.gender = gender;
		this.nationality = nationality;
		this.address = address;
		this.patientStatus = patientStatus;
		this.patientDescription = patientDescription;
	}
	public Patient() {
		super();
	}
	public String getTimeUpdate() {
		return timeUpdate;
	}
	public String getPatientId() {
		return patientId;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public String getNationality() {
		return nationality;
	}
	public String getAddress() {
		return address;
	}
	public String getPatientStatus() {
		return patientStatus;
	}
	public String getPatientDescription() {
		return patientDescription;
	}
	public void setTimeUpdate(String timeUpdate) {
		this.timeUpdate = timeUpdate;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPatientStatus(String patientStatus) {
		this.patientStatus = patientStatus;
	}
	public void setPatientDescription(String patientDescription) {
		this.patientDescription = patientDescription;
	}
	@Override
	public String toString() {
		return "PatientInfoDAO [timeUpdate=" + timeUpdate + ", patientId=" + patientId + ", age=" + age + ", gender="
				+ gender + ", nationality=" + nationality + ", address=" + address + ", patientStatus=" + patientStatus
				+ ", patientDescription=" + patientDescription + "]";
	}
}
