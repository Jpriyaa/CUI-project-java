package com.demo.response;

import java.util.List;

import com.demo.vo.RoomVO;

public class RoomResponseObject {
	String successMessage;
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getFailureMessage() {
		return FailureMessage;
	}
	public void setFailureMessage(String failureMessage) {
		FailureMessage = failureMessage;
	}
	public RoomVO getRoomvo() {
		return roomvo;
	}
	public void setRoomvo(RoomVO roomvo) {
		this.roomvo = roomvo;
	}
	public List<RoomVO> getRoomList() {
		return roomList;
	}
	public void setRoomList(List<RoomVO> roomList) {
		this.roomList = roomList;
	}
	String FailureMessage;
	RoomVO roomvo;
	List<RoomVO> roomList;

}
