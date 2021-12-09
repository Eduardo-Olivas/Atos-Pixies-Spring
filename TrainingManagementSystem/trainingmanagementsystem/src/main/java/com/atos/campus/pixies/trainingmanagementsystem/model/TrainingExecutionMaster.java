package com.atos.campus.pixies.trainingmanagementsystem.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

@Entity
public class TrainingExecutionMaster {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXCSequence")
    @GenericGenerator(
		name = "EXCSequence", 
        strategy = "com.atos.campus.pixies.trainingmanagementsystem.model.StringIdGenerator", 
        parameters = {
			@Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringIdGenerator.PREFIX, value = "EXC"),
            @Parameter(name = StringIdGenerator.NUMBER_FORMAT, value = "%02d")})
	private String ExecutionID;
	private String ProposalID;
	private Date ConfirmedDate;
	private String ConfirmedTime;
	private String Trainer;
	private int TotalHRS;
	private String ProposalStatus;
	private int TotalParticipantsAllowed;
	private String TrainerResponse;

	public String getTrainerResponse() {
		return this.TrainerResponse;
	}

	public void setTrainerResponse(String TrainerResponse) {
		this.TrainerResponse = TrainerResponse;
	}
	
	public String getProposalID() {
		return ProposalID;
	}
	public void setProposalID(String ProposalID) {
		this.ProposalID = ProposalID;
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
	@Override
	public String toString() {
		return "TrainingExecutionMaster [ProposalID=" + ProposalID + ", ExecutionID=" + ExecutionID
				+ ", ConfirmedDate=" + ConfirmedDate + ", ConfirmedTime=" + ConfirmedTime + ", Trainer=" + Trainer
				+ ", TotalHRS=" + TotalHRS + ", ProposalStatus=" + ProposalStatus + ", TotalParticipantsAllowed="
				+ TotalParticipantsAllowed + "]";
	}
	
}
