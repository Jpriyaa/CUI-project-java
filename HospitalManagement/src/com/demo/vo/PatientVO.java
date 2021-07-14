package com.demo.vo;

import java.sql.Date;

public class PatientVO {
	private int patient_Id;

	
	public int getPatient_Id() {
		return patient_Id;
	}

	public void setPatient_Id(int patient_Id) {
		this.patient_Id = patient_Id;
	}
	public String getPatient_Name() {
		return patient_Name;
	}
	public void setPatient_Name(String patient_Name) {
		this.patient_Name = patient_Name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	
	@Override
	public String toString() {
		return "PatientVO [patient_Id=" + patient_Id + ", patient_Name=" + patient_Name + ", Age=" + Age + ", Address="
				+ Address + ", phone_no=" + phone_no + ", DateOfBirth=" + DateOfBirth + "]";
	}

	private String patient_Name;
	private int Age;
	private String Address;
	private long phone_no;
	private Date DateOfBirth;


	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}



	
	

}
