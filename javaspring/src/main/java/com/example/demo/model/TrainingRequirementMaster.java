package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TrainingRequirementMaster {

	@Id
	private String RequirementID;
	private Date RequirementReceivedDate;
	private String RequirementUser;
	private String RequirementUserVertical;
	private String TrainingArea;
	private String TrainingDescription;
	private Date RequestedTrainingStartDate;
	private int TotalCandidates;
	private String TrainingTimeZone;
	private int TotalDurationDays;
	
	
	public String getRequirementID() {
		return RequirementID;
	}
	public void setRequirementID(String requirementID) {
		RequirementID = requirementID;
	}
	public Date getRequirementReceivedDate() {
		return RequirementReceivedDate;
	}
	public void setRequirementReceivedDate(Date requirementReceivedDate) {
		RequirementReceivedDate = requirementReceivedDate;
	}
	public String getRequirementUser() {
		return RequirementUser;
	}
	public void setRequirementUser(String requirementUser) {
		RequirementUser = requirementUser;
	}
	public String getRequirementUserVertical() {
		return RequirementUserVertical;
	}
	public void setRequirementUserVertical(String requirementUserVertical) {
		RequirementUserVertical = requirementUserVertical;
	}
	public String getTrainingArea() {
		return TrainingArea;
	}
	public void setTrainingArea(String trainingArea) {
		TrainingArea = trainingArea;
	}
	public String getTrainingDescription() {
		return TrainingDescription;
	}
	public void setTrainingDescription(String trainingDescription) {
		TrainingDescription = trainingDescription;
	}
	public Date getRequestedTrainingStartDate() {
		return RequestedTrainingStartDate;
	}
	public void setRequestedTrainingStartDate(Date requestedTrainingStartDate) {
		RequestedTrainingStartDate = requestedTrainingStartDate;
	}
	public int getTotalCandidates() {
		return TotalCandidates;
	}
	public void setTotalCandidates(int totalCandidates) {
		TotalCandidates = totalCandidates;
	}
	public String getTrainingTimeZone() {
		return TrainingTimeZone;
	}
	public void setTrainingTimeZone(String trainingTimeZone) {
		TrainingTimeZone = trainingTimeZone;
	}
	public int getTotalDurationDays() {
		return TotalDurationDays;
	}
	public void setTotalDurationDays(int totalDurationDays) {
		TotalDurationDays = totalDurationDays;
	}
	
	
	
	
}
