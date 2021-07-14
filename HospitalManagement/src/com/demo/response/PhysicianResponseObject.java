package com.demo.response;

import java.util.List;

import com.demo.vo.PhysicianVO;

public class PhysicianResponseObject {
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
	public PhysicianVO getPhysicianvo() {
		return physicianvo;
	}
	public void setPhysicianvo(PhysicianVO physicianvo) {
		this.physicianvo = physicianvo;
	}
	public List<PhysicianVO> getPhysicianList() {
		return physicianList;
	}
	public void setPhysicianList(List<PhysicianVO> physicianList) {
		this.physicianList = physicianList;
	}
	String failureMessage;
	PhysicianVO physicianvo;
    List<PhysicianVO> physicianList;
}
