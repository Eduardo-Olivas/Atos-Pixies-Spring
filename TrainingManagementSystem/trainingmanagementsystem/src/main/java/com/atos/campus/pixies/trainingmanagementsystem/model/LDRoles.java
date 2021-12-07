package com.atos.campus.pixies.trainingmanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

@Entity
public class LDRoles {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LDRSequence")
    @GenericGenerator(
		name = "LDRSequence", 
        strategy = "com.atos.campus.pixies.trainingmanagementsystem.model.StringIdGenerator", 
        parameters = {
			@Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringIdGenerator.PREFIX, value = "LDR"),
            @Parameter(name = StringIdGenerator.NUMBER_FORMAT, value = "%02d")})
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
