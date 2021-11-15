package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TrainingParticipantData {

	@Id
	private String ParticipantID;
	private String EmployeeID;
	private String EmployeeName;
	private String Email;
	private String Contact;
	private String RequirementID;
	private String AttendanceStatus;
	
	public String getParticipantID() {
		return ParticipantID;
	}
	public void setParticipantID(String participantID) {
		ParticipantID = participantID;
	}
	public String getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public String getRequirementID() {
		return RequirementID;
	}
	public void setRequirementID(String requirementID) {
		RequirementID = requirementID;
	}
	public String getAttendanceStatus() {
		return AttendanceStatus;
	}
	public void setAttendanceStatus(String attendanceStatus) {
		AttendanceStatus = attendanceStatus;
	}
	
	
	
}
