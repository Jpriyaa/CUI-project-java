package com.demo.response;

import java.util.List;

import com.demo.vo.PatientVO;

public class PatientResponseObject {
	String successMessage;
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getFailureMessage() {
		return failureMessage;
	}
	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}
	public PatientVO getPatientvo() {
		return patientvo;
	}
	public void setPatientvo(PatientVO patientvo) {
		this.patientvo = patientvo;
	}
	public List<PatientVO> getPatientList() {
		return patientList;
	}
	public void setPatientList(List<PatientVO> patientList) {
		this.patientList = patientList;
	}
	String failureMessage;
	PatientVO patientvo;
	List<PatientVO> patientList;
	

}
