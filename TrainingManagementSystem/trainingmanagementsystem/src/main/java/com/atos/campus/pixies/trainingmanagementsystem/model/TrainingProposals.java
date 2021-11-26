package net.codejava.model;

import java.util.Date;

public class TrainingProposals {

	private String ProporsalID;
	private String  ExecutionID;
	private String  MemberID;
	private Date  ProposedDate;
	private String  ProposedTime;
	private int  ProposedDuration;
	
	
	public String getProporsalID() {
		return ProporsalID;
	}
	public void setProporsalID(String proporsalID) {
		ProporsalID = proporsalID;
	}
	public String getExecutionID() {
		return ExecutionID;
	}
	public void setExecutionID(String executionID) {
		ExecutionID = executionID;
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
		return "TrainingProposals [ProporsalID=" + ProporsalID + ", ExecutionID=" + ExecutionID + ", MemberID="
				+ MemberID + ", ProposedDate=" + ProposedDate + ", ProposedTime=" + ProposedTime + ", ProposedDuration="
				+ ProposedDuration + "]";
	}
	
	
	
	
	
}
