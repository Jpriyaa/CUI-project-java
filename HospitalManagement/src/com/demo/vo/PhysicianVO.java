package com.demo.vo;

public class PhysicianVO {
	private int treatment_Id;
	public int getTreatment_Id() {
		return treatment_Id;
	}
	public void setTreatment_Id(int treatment_Id) {
		this.treatment_Id = treatment_Id;
	}
	public int getPatient_Id() {
		return patient_Id;
	}
	@Override
	public String toString() {
		return "PhysicianVO [treatment_Id=" + treatment_Id + ", patient_Id=" + patient_Id + ", physician_Id="
				+ physician_Id + ", physician_Name=" + physician_Name + ", physician_Charge=" + physician_Charge
				+ ", specialization=" + specialization + "]";
	}
	public void setPatient_Id(int patient_Id) {
		this.patient_Id = patient_Id;
	}
	public int getPhysician_Id() {
		return physician_Id;
	}
	public void setPhysician_Id(int physician_Id) {
		this.physician_Id = physician_Id;
	}
	public String getPhysician_Name() {
		return physician_Name;
	}
	public void setPhysician_Name(String physician_Name) {
		this.physician_Name = physician_Name;
	}
	
	private int patient_Id;
	private int physician_Id;
	private String physician_Name;
	private double physician_Charge;
	public double getPhysician_Charge() {
		return physician_Charge;
	}
	public void setPhysician_Charge(double physician_Charge) {
		this.physician_Charge = physician_Charge;
	}

	private String specialization;
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

}
