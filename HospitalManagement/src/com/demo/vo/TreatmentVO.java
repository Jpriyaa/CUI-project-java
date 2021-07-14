package com.demo.vo;

public class TreatmentVO {
	private int patient_Id;
	@Override
	public String toString() {
		return "TreatmentVO [patient_Id=" + patient_Id + ", Diseases=" + Diseases + ", Treatment_Id=" + Treatment_Id
				+ ", Treatment_description=" + Treatment_description + ", Charge=" + Charge + "]";
	}
	public int getPatient_Id() {
		return patient_Id;
	}
	public void setPatient_Id(int patient_Id) {
		this.patient_Id = patient_Id;
	}
	public String getDiseases() {
		return Diseases;
	}
	public void setDiseases(String diseases) {
		Diseases = diseases;
	}
	public int getTreatment_Id() {
		return Treatment_Id;
	}
	public void setTreatment_Id(int treatment_Id) {
		Treatment_Id = treatment_Id;
	}
	public String getTreatment_description() {
		return Treatment_description;
	}
	public void setTreatment_description(String treatment_description) {
		Treatment_description = treatment_description;
	}
	public double getCharge() {
		return Charge;
	}
	public void setCharge(double charge) {
		Charge = charge;
	}
	private String Diseases;
	private int Treatment_Id;
	private String Treatment_description;
	private double Charge;
	

}
