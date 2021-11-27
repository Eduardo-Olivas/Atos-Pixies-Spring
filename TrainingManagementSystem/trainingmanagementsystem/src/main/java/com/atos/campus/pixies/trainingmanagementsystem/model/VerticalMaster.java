package com.atos.campus.pixies.trainingmanagementsystem.model;

public class VerticalMaster {
	
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
