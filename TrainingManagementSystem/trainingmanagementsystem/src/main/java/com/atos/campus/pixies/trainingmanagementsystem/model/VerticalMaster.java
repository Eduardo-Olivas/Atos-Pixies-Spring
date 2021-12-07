package com.atos.campus.pixies.trainingmanagementsystem.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

@Entity
public class VerticalMaster {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIDSequence")
    @GenericGenerator(
		name = "VIDSequence", 
        strategy = "com.atos.campus.pixies.trainingmanagementsystem.model.StringIdGenerator", 
        parameters = {
			@Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringIdGenerator.PREFIX, value = "VID"),
            @Parameter(name = StringIdGenerator.NUMBER_FORMAT, value = "%02d")})
	private String VID;
	private String VerticalName;
	private String VerticalLBPID;
	
	public String getVID() {
		return VID;
	}
	public void setVID(String vID) {
		VID = vID;
	}
	public String getVerticalName() {
		return VerticalName;
	}
	public void setVerticalName(String verticalName) {
		VerticalName = verticalName;
	}
	public String getVerticalLBPID() {
		return VerticalLBPID;
	}
	public void setVerticalLBPID(String verticalLBPID) {
		VerticalLBPID = verticalLBPID;
	}
	@Override
	public String toString() {
		return "VerticalMaster [VID=" + VID + ", VerticalName=" + VerticalName + ", VerticalLBPID=" + VerticalLBPID
				+ "]";
	}
	
	
	
}
