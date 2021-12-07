package com.atos.campus.pixies.trainingmanagementsystem.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class TrainingProposals {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TPSequence")
    @GenericGenerator(
		name = "TPSequence", 
        strategy = "com.atos.campus.pixies.trainingmanagementsystem.model.StringIdGenerator", 
        parameters = {
			@Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringIdGenerator.PREFIX, value = "TP"),
            @Parameter(name = StringIdGenerator.NUMBER_FORMAT, value = "%03d")})
	private String ProposalID;
	private String  RequirementID;
	private String  MemberID;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date  ProposedDate;
	private String  ProposedTime;
	private int  ProposedDuration;
	private String ProposalStatus;

	public TrainingProposals(){};

	public TrainingProposals(String RequirementID, String MemberID) throws ParseException {
		this.RequirementID = RequirementID;
		this.MemberID = MemberID;
		this.ProposedDate = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01");
		this.ProposedTime = "";
		this.ProposedDuration = 0;
	}
	
	public String getProposalID() {
		return ProposalID;
	}
	public void setProposalID(String proposalID) {
		ProposalID = proposalID;
	}
	public String getRequirementID() {
		return RequirementID;
	}
	public void setRequirementID(String requirementID) {
		RequirementID = requirementID;
	}
	public String getMemberID() {
		return MemberID;
	}
	public void setMemberID(String memberID) {
		MemberID = memberID;
	}
	public Date getProposedDate() {
		return ProposedDate;
	}
	public void setProposedDate(Date proposedDate) {
		ProposedDate = proposedDate;
	}
	public String getProposedTime() {
		return ProposedTime;
	}
	public void setProposedTime(String proposedTime) {
		ProposedTime = proposedTime;
	}
	public int getProposedDuration() {
		return ProposedDuration;
	}
	public void setProposedDuration(int proposedDuration) {
		ProposedDuration = proposedDuration;
	}
	public String getProposalStatus() {
		return ProposalStatus;
	}
	public void setProposalStatus(String ProposalStatus) {
		this.ProposalStatus = ProposalStatus;
	}

	@Override
	public String toString() {
		return "TrainingProposals [ProposalID=" + ProposalID + ", RequirementID=" + RequirementID + ", MemberID="
				+ MemberID + ", ProposedDate=" + ProposedDate + ", ProposedTime=" + ProposedTime + ", ProposedDuration="
				+ ProposedDuration + "]";
	}
	
	
	
	
	
}
