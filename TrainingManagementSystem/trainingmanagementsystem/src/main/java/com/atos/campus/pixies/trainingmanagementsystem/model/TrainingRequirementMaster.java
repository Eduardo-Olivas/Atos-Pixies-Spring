package com.atos.campus.pixies.trainingmanagementsystem.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class TrainingRequirementMaster {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRMSequence")
    @GenericGenerator(
		name = "TRMSequence", 
        strategy = "com.atos.campus.pixies.trainingmanagementsystem.model.StringIdGenerator", 
        parameters = {
			@Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringIdGenerator.PREFIX, value = "TRM"),
            @Parameter(name = StringIdGenerator.NUMBER_FORMAT, value = "%02d")})
	private String RequirementID;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date RequirementReceivedDate; //
	private String RequirementUser;
	private String RequirementUserVertical; //
	private String TrainingArea;  //
	private String TrainingDescription; //
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date RequestedTrainingStartDate;
	private int TotalCandidates; //
	private String TrainingTimeZone; //
 	private int TotalDurationDays; //
	
	
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
		this.RequirementReceivedDate = requirementReceivedDate;
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
	@Override
	public String toString() {
		return "TrainingRequirementMaster [RequirementID=" + RequirementID + ", RequirementReceivedDate="
				+ RequirementReceivedDate + ", RequirementUser=" + RequirementUser + ", RequirementUserVertical="
				+ RequirementUserVertical + ", TrainingArea=" + TrainingArea + ", TrainingDescription="
				+ TrainingDescription + ", RequestedTrainingStartDate=" + RequestedTrainingStartDate
				+ ", TotalCandidates=" + TotalCandidates + ", TrainingTimeZone=" + TrainingTimeZone
				+ ", TotalDurationDays=" + TotalDurationDays + "]";
	}
	

}
