package net.codejava.model;



public class LDMemberData {


	private String MemberID;
	private String MemberName;
	private String MemberContact;
	private String MemberLocation;
	private String MemberEmail;
	private String LDRoleID;
	
	public String getMemberID() {
		return MemberID;
	}
	public void setMemberID(String memberID) {
		MemberID = memberID;
	}
	public String getMemberName() {
		return MemberName;
	}
	public void setMemberName(String memberName) {
		MemberName = memberName;
	}
	public String getMemberContact() {
		return MemberContact;
	}
	public void setMemberContact(String memberContact) {
		MemberContact = memberContact;
	}
	public String getMemberLocation() {
		return MemberLocation;
	}
	public void setMemberLocation(String memberLocation) {
		MemberLocation = memberLocation;
	}
	public String getMemberEmail() {
		return MemberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		MemberEmail = memberEmail;
	}
	public String getLDRoleID() {
		return LDRoleID;
	}
	public void setLDRoleID(String lDRoleID) {
		LDRoleID = lDRoleID;
	}
	
	@Override
	public String toString() {
		return "LDMemberData [MemberID=" + MemberID + ", MemberName=" + MemberName + ", MemberContact=" + MemberContact
				+ ", MemberLocation=" + MemberLocation + ", MemberEmail=" + MemberEmail + ", LDRoleID=" + LDRoleID
				+ "]";
	}
	
	


	
}
