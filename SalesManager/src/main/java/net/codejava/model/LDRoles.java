package net.codejava.model;


public class LDRoles {
	

	private String LDRoleID;
	private String LDRoleName;
	private String LDRoleDescription;
	
	public String getLDRoleID() {
		return LDRoleID;
	}
	public void setLDRoleID(String lDRoleID) {
		LDRoleID = lDRoleID;
	}
	public String getLDRoleName() {
		return LDRoleName;
	}
	public void setLDRoleName(String lDRoleName) {
		LDRoleName = lDRoleName;
	}
	public String getLDRoleDescription() {
		return LDRoleDescription;
	}
	public void setLDRoleDescription(String lDRoleDescription) {
		LDRoleDescription = lDRoleDescription;
	}
	
	@Override
	public String toString() {
		return "LDRoles [LDRoleID=" + LDRoleID + ", LDRoleName=" + LDRoleName + ", LDRoleDescription="
				+ LDRoleDescription + "]";
	}
	
	
	
}
