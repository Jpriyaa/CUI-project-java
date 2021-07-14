package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.demo.bo.HospitalManagementBO;
import com.demo.exception.PatientManagementException;
import com.demo.exception.PatientNotFoundException;
import com.demo.exception.PhysicianManagementException;
import com.demo.exception.PhysicianNotFoundException;
import com.demo.exception.RoomManagementException;
import com.demo.exception.RoomNotFoundException;
import com.demo.exception.TreatmentManagementException;
import com.demo.exception.TreatmentNotFoundException;
import com.demo.response.PatientResponseObject;
import com.demo.response.PhysicianResponseObject;
import com.demo.response.RoomResponseObject;
import com.demo.response.TreatmentResponseObject;
import com.demo.vo.PatientVO;
import com.demo.vo.PhysicianVO;
import com.demo.vo.RoomVO;
import com.demo.vo.TreatmentVO;

public class HospitalManagementService {
	PatientResponseObject obj = new PatientResponseObject();
	PhysicianResponseObject obj4=new PhysicianResponseObject();
	TreatmentResponseObject obj2 = new TreatmentResponseObject();
	RoomResponseObject obj3 = new RoomResponseObject();
	HospitalManagementBO bo = new HospitalManagementBO();
	
   // patient service
	public PatientResponseObject addPatientDetails(PatientVO vo) throws PatientManagementException {
		boolean flag = false;
		try {
			flag = bo.addPatientDetails(vo);
			if (flag) {
				obj.setSuccessMessage("Patient added sucessfully");
			} else {
				obj.setFailureMessage("Error not added");
			}
		} catch (PatientManagementException e) {
			throw new PatientManagementException("Error when adding Patient Details..." + e.getMessage());
		}
		return obj;
	}

	public PatientResponseObject fetchPatientById(int patient_Id) throws PatientNotFoundException {
		try {
			PatientVO vo;
			vo = bo.fetchPatientById(patient_Id);
			obj.setPatientvo(vo);
		} catch (PatientNotFoundException e) {
			obj.setFailureMessage("Fetched Patient is not exist in the list");
		}
		return obj;
	}

	public PatientResponseObject fetchPatientByName(String patient_Name) throws PatientNotFoundException {

		try {
			List<PatientVO> list = new ArrayList<>();
			list = bo.fetchPatientByName(patient_Name);
			obj.setPatientList(list);
		} catch (PatientNotFoundException e) {
			obj.setFailureMessage("Fetched Patient is not exist in the list");
		}
		return obj;
	}

	public PatientResponseObject updatePatient(PatientVO vo) throws PatientManagementException {
		boolean flag = false;
		try {
			flag = bo.updatePatient(vo);
			if (flag) {
				obj.setSuccessMessage("Updated sucessfully");
			} else {
				obj.setFailureMessage("Error to update");
			}
		} catch (PatientManagementException e) {
			throw new PatientManagementException("Error when updating Patient Details..." + e.getMessage());
		}
		return obj;
	}

	//Treatment Service

	public TreatmentResponseObject addTreatmentDetails(TreatmentVO vo) throws TreatmentManagementException {
		boolean flag = false;
		try {
			flag = bo.addTreatmentDetails(vo);
			if (flag) {
				obj2.setSuccessMessage("Treatment added sucessfully");
			} else {
				obj2.setFailureMessage("Error not added");
			}
		} catch (TreatmentManagementException e) {
			throw new TreatmentManagementException("Error when adding Treatment Details..." + e.getMessage());
		}
		return obj2;
	}

	public TreatmentResponseObject fetchTreatmentById(int Treatment_Id) throws TreatmentNotFoundException {
		try {
			TreatmentVO vo =new TreatmentVO();
			vo = bo.fetchTreatmentById(Treatment_Id);
			obj2.setTreatmentvo(vo);
		} catch (TreatmentNotFoundException e) {
			obj2.setFailureMessage("Fetched Treatment is not exist in the list");
		}
		return obj2;
	}
	public void fetchTreatmentByUsingJoins() throws TreatmentNotFoundException {
		try {
			
			 bo.fetchTreatmentByIdUsingJoins();
			
		} catch (TreatmentNotFoundException e) {
			obj2.setFailureMessage("Fetched patient is not exist in the list");
		}
		
	}

	public TreatmentResponseObject fetchTreatmentByDiseases(String Diseases) throws TreatmentNotFoundException {

		try {
			List<TreatmentVO> list = new ArrayList<>();
			list = bo.fetchTreatmentByDiseases(Diseases);
			obj2.setTreatmentList(list);
		} catch (TreatmentNotFoundException e) {
			obj2.setFailureMessage("Fetched Treatment is not exist in the list");
		}
		return obj2;
	}

	public TreatmentResponseObject updateTreatmentDetails(TreatmentVO vo) throws TreatmentManagementException {
		boolean flag = false;
		try {
			flag = bo.updateTreatmentDetails(vo);
			if (flag) {
				obj2.setSuccessMessage("Updated sucessfully");
			} else {
				obj2.setFailureMessage("Error to update");
			}
		} catch (TreatmentManagementException e) {
			throw new TreatmentManagementException("Error when updating Treatment Details..." + e.getMessage());
			}
		return obj2;
	}
	
   // Room service
	public RoomResponseObject addRoomDetails(RoomVO vo) throws RoomManagementException {
		boolean flag = false;
		try {
			flag = bo.addRoomDetails(vo);
			if (flag) {
				obj3.setSuccessMessage("Room details added successfully");
			} else {
				obj3.setFailureMessage("Error not added");
			}
		} catch (RoomManagementException e) {
			throw new RoomManagementException("Error when adding Room Details..." + e.getMessage());
		}
		return obj3;
	}
	public RoomResponseObject fetchRoomByRoomNumber(int Room_NO) throws RoomNotFoundException {
		try {
			RoomVO vo =new RoomVO();
			vo = bo.fetchRoomByRoomNumber(Room_NO);
			obj3.setRoomvo(vo);
		} catch (RoomNotFoundException e) {
			obj3.setFailureMessage("Fetched Room is not exist in the list");
		}
		return obj3;
	}
	public RoomResponseObject fetchRoomByLocation(String Room_Location) throws RoomNotFoundException {

		try {
			List<RoomVO> list = new ArrayList<>();
			list = bo.fetchRoomByLocation(Room_Location);
			obj3.setRoomList(list);
		} catch (RoomNotFoundException e) {
			obj3.setFailureMessage("Fetched Room is not exist in the list");
		}
		return obj3;
	}
	public RoomResponseObject updateRoomDetails(RoomVO vo) throws RoomManagementException {
		boolean flag = false;
		try {
			flag = bo.updateRoomDetails(vo);
			if (flag) {
				obj3.setSuccessMessage("Updated sucessfully");
			} else {
				obj3.setFailureMessage("Error to update");
			}
		} catch (RoomManagementException e) {
			throw new RoomManagementException("Error when updating Room Details..." + e.getMessage());
		}
		return obj3;
	}
	
	// Pysician Service
	public PhysicianResponseObject addPhysicianDetails(PhysicianVO vo) throws PhysicianManagementException {
		boolean flag = false;
		try {
			flag = bo.addPhysicainDetails(vo);
			if (flag) {
				obj4.setSuccessMessage("Room details added successfully");
			} else {
				obj4.setFailureMessage("Error not added");
			}
		} catch (PhysicianManagementException e) {
			throw new PhysicianManagementException("Error when adding Room Details..." + e.getMessage());
		}
		return obj4;
	}
	public PhysicianResponseObject fetchPhysicianById(int Physician_Id) throws PhysicianNotFoundException {
		try {
			PhysicianVO vo =new PhysicianVO();
			vo = bo.fetchPhysicianById(Physician_Id);
			obj4.setPhysicianvo(vo);
		} catch (PhysicianNotFoundException e) {
			obj3.setFailureMessage("Fetched physician is not exist in the list");
		}
		return obj4;
	}
	public PhysicianResponseObject fetchPhysiciantByName(String Physician_Name) throws PhysicianNotFoundException {

		try {
			List<PhysicianVO> list = new ArrayList<>();
			list = bo.fetchPhysicianByName(Physician_Name);
			obj4.setPhysicianList(list);
		} catch (PhysicianNotFoundException e) {
			obj4.setFailureMessage("Fetched Patient is not exist in the list");
		}
		return obj4;
	}
	public PhysicianResponseObject updatePhysicianDetails(PhysicianVO vo) throws PhysicianManagementException {
		boolean flag = false;
		try {
			flag = bo.updatePhysicianDetails(vo);
			if (flag) {
				obj4.setSuccessMessage("Updated sucessfully");
			} else {
				obj4.setFailureMessage("Error to update");
			}
		} catch (PhysicianManagementException e) {
			throw new PhysicianManagementException("Error when updating Room Details..." + e.getMessage());
		}
		return obj4;
	}
}


