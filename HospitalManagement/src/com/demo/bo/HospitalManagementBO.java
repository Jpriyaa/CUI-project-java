package com.demo.bo;

import java.util.ArrayList;
import java.util.List;

import com.demo.dao.PatientDAO;
import com.demo.dao.PhysicianDAO;
import com.demo.dao.RoomDAO;
import com.demo.dao.TreatmentDAO;
import com.demo.exception.PatientManagementException;
import com.demo.exception.PatientNotFoundException;
import com.demo.exception.PhysicianManagementException;
import com.demo.exception.PhysicianNotFoundException;
import com.demo.exception.RoomManagementException;
import com.demo.exception.RoomNotFoundException;
import com.demo.exception.TreatmentManagementException;
import com.demo.exception.TreatmentNotFoundException;
import com.demo.vo.PatientVO;
import com.demo.vo.PhysicianVO;
import com.demo.vo.RoomVO;
import com.demo.vo.TreatmentVO;

public class HospitalManagementBO {

	PatientDAO dao = new PatientDAO();
	TreatmentDAO dao1 = new TreatmentDAO();
	RoomDAO dao2 = new RoomDAO();
	PhysicianDAO dao3 = new PhysicianDAO();
	
    // Patient BO
	public boolean addPatientDetails(PatientVO vo) throws PatientManagementException {
		try {
			boolean flag = false;
			flag = dao.addPatientDetails(vo);
			return flag;
		} catch (PatientManagementException e) {
			throw new PatientManagementException("Error when adding Patient Details..." + e.getMessage());
		}
	}

	public PatientVO fetchPatientById(int patient_Id) throws PatientNotFoundException {
		try {
			PatientVO vo = new PatientVO();
			vo = dao.fetchPatientById(patient_Id);
			return vo;
		} catch (PatientNotFoundException e) {
			throw new PatientNotFoundException("Given Patient Id is not Exist in Database");
		}
	}

	public List<PatientVO> fetchPatientByName(String patient_Name) throws PatientNotFoundException {

		try {
			List<PatientVO> list = new ArrayList<>();
			list = dao.fetchPatientByName(patient_Name);
			return list;

		} catch (PatientNotFoundException e) {
			throw new PatientNotFoundException("Given Patient Name is not Exist in Database");
		}

	}

	public boolean updatePatient(PatientVO vo) throws PatientManagementException {
		try {
			boolean flag = false;
			flag = dao.updatePatient(vo);
			return flag;
		} catch (PatientManagementException e) {
			throw new PatientManagementException("Error when updating Patient Details..." + e.getMessage());
		}
	}
	
  // TreatmentBO
	public boolean addTreatmentDetails(TreatmentVO vo) throws TreatmentManagementException {
		try {
			boolean flag = false;
			flag = dao1.addTreatmentDetails(vo);
			return flag;
		} catch (TreatmentManagementException e) {
			throw new TreatmentManagementException("Error when adding Treatment Details..." + e.getMessage());
		}
	}

	public TreatmentVO fetchTreatmentById(int Treatment_Id) throws TreatmentNotFoundException {
		try {
			TreatmentVO vo = new TreatmentVO();
			vo = dao1.fetchTreatmentById(Treatment_Id);
			return vo;
		} catch (TreatmentNotFoundException e) {
			throw new TreatmentNotFoundException("Given Treatment Id is not Exist in Database");
		}
	}
	public void fetchTreatmentByIdUsingJoins() throws TreatmentNotFoundException {
		try {
              dao1.fetchTreatmentByIdUsingJoins();
		} catch (TreatmentNotFoundException e) {
			throw new TreatmentNotFoundException("Given patient Id is not Exist in Database");
		}
	}

	public List<TreatmentVO> fetchTreatmentByDiseases(String Diseases) throws TreatmentNotFoundException {

		try {
			List<TreatmentVO> list = new ArrayList<>();
			list = dao1.fetchTreatmentByDisease(Diseases);
			return list;

		} catch (TreatmentNotFoundException e) {
			throw new TreatmentNotFoundException("Given Disease Name is not Exist in Database");
		}

	}

	public boolean updateTreatmentDetails(TreatmentVO vo) throws TreatmentManagementException {
		try {
			boolean flag = false;
			flag = dao1.updateTreatmentDetails(vo);
			return flag;
		} catch (TreatmentManagementException e) {
			throw new TreatmentManagementException("Error when updating Treatment Details..." + e.getMessage());
		}
	}
	
  // Room BO
	public boolean addRoomDetails(RoomVO vo) throws RoomManagementException {
		try {
			boolean flag = false;
			flag = dao2.addRoomDetails(vo);
			return flag;
		} catch (RoomManagementException e) {
			throw new RoomManagementException("Error when adding Room Details..." + e.getMessage());
		}
	}

	public RoomVO fetchRoomByRoomNumber(int Room_NO) throws RoomNotFoundException {
		try {
			RoomVO vo = new RoomVO();
			vo = dao2.fetchRoomByRoomNumber(Room_NO);
			return vo;
		} catch (RoomNotFoundException e) {
			throw new RoomNotFoundException("Given Room ID is not Exist in Database");
		}
	}

	public List<RoomVO> fetchRoomByLocation(String Room_Location) throws RoomNotFoundException {

		try {
			List<RoomVO> list = new ArrayList<>();
			list = dao2.fetchRoomByLocation(Room_Location);
			return list;

		} catch (RoomNotFoundException e) {
			throw new RoomNotFoundException("Given Room location is not Exist in Database");
		}

	}

	public boolean updateRoomDetails(RoomVO vo) throws RoomManagementException {
		try {
			boolean flag = false;
			flag = dao2.updateRoomDetails(vo);
			return flag;
		} catch (RoomManagementException e) {
			throw new RoomManagementException("Error when updating Room Details..." + e.getMessage());
		}
	}
 
	// Pahysician BO
	public boolean addPhysicainDetails(PhysicianVO vo) throws PhysicianManagementException {
		try {
			boolean flag = false;
			flag = dao3.addPhysicianDetails(vo);
			return flag;
		} catch (PhysicianManagementException e) {
			throw new PhysicianManagementException("Error when adding Physician Details..." + e.getMessage());
		}
	}
	public PhysicianVO fetchPhysicianById(int physician_Id) throws PhysicianNotFoundException {
		try {
			PhysicianVO vo = new PhysicianVO();
			vo = dao3.fetchPhysicianById(physician_Id);
			return vo;
		} catch (PhysicianNotFoundException e) {
			throw new PhysicianNotFoundException("Given Physician ID is not Exist in Database");
		}
	}
	public List<PhysicianVO> fetchPhysicianByName(String Physician_Name) throws PhysicianNotFoundException {

		try {
			List<PhysicianVO> list = new ArrayList<>();
			list = dao3.fetchPhysicianByName(Physician_Name);
			return list;

		} catch (PhysicianNotFoundException e) {
			throw new PhysicianNotFoundException("Given Patient Name is not Exist in Database");
		}

	}
	public boolean updatePhysicianDetails(PhysicianVO vo) throws PhysicianManagementException {
		try {
			boolean flag = false;
			flag = dao3.updatePhysicianDetails(vo);
			return flag;
		} catch (PhysicianManagementException e) {
			throw new PhysicianManagementException("Error when updating Physician Details..." + e.getMessage());
		}
	}
	
}
