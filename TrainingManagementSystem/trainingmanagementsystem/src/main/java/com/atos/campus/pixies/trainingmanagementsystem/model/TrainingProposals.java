package com.atos.campus.pixies.trainingmanagementsystem.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TrainingProposals {

	private String ProporsalID;
	private String  RequirementID;
	private String  MemberID;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date  ProposedDate;
	private String  ProposedTime;
	private int  ProposedDuration;
	
	
	public String getProporsalID() {
		return ProporsalID;
	}
	public void setProporsalID(String proporsalID) {
		ProporsalID = proporsalID;
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
	@Override
	public String toString() {
		return "TrainingProposals [ProporsalID=" + ProporsalID + ", RequirementID=" + RequirementID + ", MemberID="
				+ MemberID + ", ProposedDate=" + ProposedDate + ", ProposedTime=" + ProposedTime + ", ProposedDuration="
				+ ProposedDuration + "]";
	}
	
	
	
	
	
}
