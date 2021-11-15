package com.example.demo.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TrainingExecutionMaster {

	@Id
	private String RequirementID;
	private String ExecutionID;
	private Date ConfirmedDate;
	private String ConfirmedTime;
	private String Trainer;
	private int TotalHRS;
	private String ProposalStatus;
	private int TotalParticipantsAllowed;
	
	
	public String getRequirementID() {
		return RequirementID;
	}
	public void setRequirementID(String requirementID) {
		RequirementID = requirementID;
	}
	public String getExecutionID() {
		return ExecutionID;
	}
	public void setExecutionID(String executionID) {
		ExecutionID = executionID;
	}
	public Date getConfirmedDate() {
		return ConfirmedDate;
	}
	public void setConfirmedDate(Date confirmedDate) {
		ConfirmedDate = confirmedDate;
	}
	public String getConfirmedTime() {
		return ConfirmedTime;
	}
	public void setConfirmedTime(String confirmedTime) {
		ConfirmedTime = confirmedTime;
	}
	public String getTrainer() {
		return Trainer;
	}
	public void setTrainer(String trainer) {
		Trainer = trainer;
	}
	public int getTotalHRS() {
		return TotalHRS;
	}
	public void setTotalHRS(int totalHRS) {
		TotalHRS = totalHRS;
	}
	public String getProposalStatus() {
		return ProposalStatus;
	}
	public void setProposalStatus(String proposalStatus) {
		ProposalStatus = proposalStatus;
	}
	public int getTotalParticipantsAllowed() {
		return TotalParticipantsAllowed;
	}
	public void setTotalParticipantsAllowed(int totalParticipantsAllowed) {
		TotalParticipantsAllowed = totalParticipantsAllowed;
	}
	
	
	
}
