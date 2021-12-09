package com.atos.campus.pixies.trainingmanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class RequirementConfirmed {
    
    @Id
    private String ExecutionID;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date RequirementReceivedDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date ProposedDate;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date ProposedEndDate;
    private String TrainerName;
    private String TotalParticipantsAllowed;

    public void setExecutionID(String executionID) {
		ExecutionID = executionID;
	}
	public Date getRequirementReceivedDate() {
		return RequirementReceivedDate;
	}
	public void setRequirementReceivedDate(Date requirementReceivedDate) {
		RequirementReceivedDate = requirementReceivedDate;
	}
	public Date getProposedDate() {
		return ProposedDate;
	}
	public void setProposedDate(Date proposedDate) {
		ProposedDate = proposedDate;
	}
	public Date getProposedEndDate() {
		return ProposedEndDate;
	}
	public void setProposedEndDate(Date proposedEndDate) {
		ProposedEndDate = proposedEndDate;
	}
	public String getTrainerName() {
		return TrainerName;
	}
	public void setTrainerName(String trainerName) {
		TrainerName = trainerName;
	}
	public String getTotalParticipantsAllowed() {
		return TotalParticipantsAllowed;
	}
	public void setTotalParticipantsAllowed(String totalParticipantsAllowed) {
		TotalParticipantsAllowed = totalParticipantsAllowed;
	}

}
