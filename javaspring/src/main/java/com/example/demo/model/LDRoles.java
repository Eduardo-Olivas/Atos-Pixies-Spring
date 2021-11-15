package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LDRoles {
	
	@Id
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
	
}
