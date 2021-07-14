package com.demo.vo;

public class RoomVO {
	private int patient_Id;
	public int getPatient_Id() {
		return patient_Id;
	}
	public void setPatient_Id(int patient_Id) {
		this.patient_Id = patient_Id;
	}
	public int getRoom_NO() {
		return Room_NO;
	}
	public void setRoom_NO(int room_NO) {
		Room_NO = room_NO;
	}
	public String getRoom_Status() {
		return Room_Status;
	}
	public void setRoom_Status(String room_Status) {
		Room_Status = room_Status;
	}
	public String getRoom_Location() {
		return Room_Location;
	}
	public void setRoom_Location(String room_Location) {
		Room_Location = room_Location;
	}
	public double getRoom_Charge() {
		return Room_Charge;
	}
	public void setRoom_Charge(double room_Charge) {
		Room_Charge = room_Charge;
	}
	private int Room_NO;
	private String Room_Status;
	private String Room_Location;
	private double Room_Charge;
	@Override
	public String toString() {
		return "RoomVO [patient_Id=" + patient_Id + ", Room_NO=" + Room_NO + ", Room_Status=" + Room_Status
				+ ", Room_Location=" + Room_Location + ", Room_Charge=" + Room_Charge + "]";
	}
	

}
