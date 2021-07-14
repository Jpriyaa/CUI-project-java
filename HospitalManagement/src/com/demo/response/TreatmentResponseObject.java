package com.demo.response;

import java.util.List;

import com.demo.vo.TreatmentVO;


public class TreatmentResponseObject {
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
	public TreatmentVO getTreatmentvo() {
		return treatmentvo;
	}
	public void setTreatmentvo(TreatmentVO treatmentvo) {
		this.treatmentvo = treatmentvo;
	}
	public List<TreatmentVO> getTreatmentList() {
		return treatmentList;
	}
	public void setTreatmentList(List<TreatmentVO> treatmentList) {
		this.treatmentList = treatmentList;
	}
	String failureMessage;
	TreatmentVO treatmentvo;
	List<TreatmentVO> treatmentList;
}
