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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ConfirmedDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String ConfirmedTime;
	private String Trainer;
	private int TotalHRS;
	private String ProposalStatus;
	private int TotalParticipantsAllowed;
	private String TrainerResponse;
	
	public TrainingExecutionMaster() {}
	
	public TrainingExecutionMaster(String ExecutionID, String ProposalID, Date ConfirmedDate, String ConfirmedTime, String Trainer, int TotalHRS, String ProposalStatus, int TotalParticipantsAllowed, String TrainerResponse) {
		int random = (int) (Math.random()* 10000);
		String randomS = String.valueOf(random);
		this.ExecutionID = randomS;
		this.ProposalID = ProposalID;
		long millis=System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis); 
		this.ConfirmedDate = date;
		this.ConfirmedTime = "00:00";
		this.Trainer = "0005";
		this.TotalHRS = 0;
		this.ProposalStatus = "Rejected";
		this.TotalParticipantsAllowed = 0;
		this.TrainerResponse = "Please enter your response";
		
	}

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
