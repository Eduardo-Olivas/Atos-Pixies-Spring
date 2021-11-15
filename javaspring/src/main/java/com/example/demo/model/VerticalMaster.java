package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VerticalMaster {

	
	@Id
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
	
	
	
}
