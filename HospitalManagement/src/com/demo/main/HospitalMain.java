package com.demo.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.demo.dao.TreatmentDAO;
import com.demo.exception.TreatmentManagementException;
import com.demo.exception.TreatmentNotFoundException;
import com.demo.response.RoomResponseObject;
import com.demo.response.TreatmentResponseObject;
import com.demo.service.HospitalManagementService;
import com.demo.vo.RoomVO;
import com.demo.vo.TreatmentVO;

public class HospitalMain {

//	public static void main(String[] args) throws PatientManagementException, PatientNotFoundException {
//		PatientVO vo = new PatientVO();
//		PatientDAO dao = new PatientDAO();
//		
//		System.out.println("Please select one of the below options");
//		System.out.println("1. Add Patient");
//		System.out.println("2. Fetch Patient by Patient id");
//		System.out.println("3. Fetch Patient by Name");
//		System.out.println("4. Update Patient Details");
//		System.out.println("5. Exit");
//		Scanner s = new Scanner(System.in);
//		int menuSelected = s.nextInt();
//		switch (menuSelected) {
//		case 1:
//			addPatientDetails();
//			break;
//		case 2:
//			fetchPatientById();
//			break;
//		case 3:
//			fetchPatientByName();
//			break;
//		case 4:
//			updatePatient();
//			break;
//		default:
//			System.exit(0);
//		}
//	}
//
//	private static void addPatientDetails() throws PatientManagementException {
//
//		Scanner s = new Scanner(System.in);
//		System.out.println("Enter the Patient's Name");
//		String patient_Name = s.next();
//		System.out.println("Enter the Age");
//		int Age = s.nextInt();
//		System.out.println("Enter the Address");
//		String Address = s.next();
//		System.out.println("Enter the phone_no");
//		long phone_no = s.nextLong();
//		System.out.println("Enter the DateOfbirth");
//		java.sql.Date DateOfBirth = Date.valueOf(s.next());
//		PatientVO vo = new PatientVO();
//		vo.setPatient_Name(patient_Name);
//		vo.setAge(Age);
//		vo.setAddress(Address);
//		vo.setPhone_no(phone_no);
//		vo.setDateOfBirth(DateOfBirth);
//		HospitalManagementService Hospitalservice = new HospitalManagementService();
//		PatientResponseObject obj;
//		obj = Hospitalservice.addPatientDetails(vo);
//		if (obj.getSuccessMessage() != null) {
//			System.out.println(obj.getSuccessMessage());
//		} else {
//			System.out.println(obj.getFailureMessage());
//		}
//
//	}
//
//	private static void fetchPatientById() throws PatientNotFoundException {
//		Scanner s = new Scanner(System.in);
//		System.out.println("Enter the PatientId to be Fetched:");
//		Integer patient_Id = Integer.parseInt(s.next());
//		PatientVO vo = new PatientVO();
//		HospitalManagementService Hospitalservice = new HospitalManagementService();
//		PatientResponseObject obj;
//		obj = Hospitalservice.fetchPatientById(patient_Id);
//		vo = obj.getPatientvo();
//		if (vo != null) {
//			System.out.println(
//					"=========================================================================================================");
//			System.out.println("patient_Id" + '\t' + "Patient_Name" + '\t' + "Age" + '\t' + "Address" + "  " + '\t'
//					+ "phone_no" + '\t' + "DateOfBirth");
//			System.out.println(
//					"=========================================================================================================");
//			System.out.println(vo.getPatient_Id() + "                " + vo.getPatient_Name() + "          "
//					+ vo.getAge() + "      " + vo.getAddress() + "         " + vo.getPhone_no() + "         "
//					+ vo.getDateOfBirth());
//
//		} else {
//			System.out.println(obj.getFailureMessage());
//		}
//
//	}
//
//	private static void fetchPatientByName() throws PatientNotFoundException {
//		Scanner s = new Scanner(System.in);
//		System.out.println("Enter the PatientName to be Fetched:");
//		String patient_Name = s.next();
//		List<PatientVO> list = new ArrayList<>();
//		HospitalManagementService Hospitalservice = new HospitalManagementService();
//		PatientResponseObject obj =null;
//		obj = Hospitalservice.fetchPatientByName(patient_Name);
//		list = obj.getPatientList();
//			System.out.println(
//					"==========================================================================================================================================");
//			System.out.println("patient_Id" + '\t' + "Patient_Name" + '\t' + "Age" + '\t' + "Address" + "  " + '\t'
//					+ "phone_no" + '\t' + "DateOfBirth");
//			if(!list.isEmpty()&& obj.getFailureMessage()==null) {
//				for(PatientVO vo:list)
//				{
//			System.out.println(
//					"==========================================================================================================================================");
//			System.out.println(vo.getPatient_Id() + "                " + vo.getPatient_Name() + "          "
//					+ vo.getAge() + "      " + vo.getAddress() + "         " + vo.getPhone_no() + "         "
//					+ vo.getDateOfBirth());
//
//				}
//
//		} else if(list.isEmpty()) {
//			System.out.println(obj.getFailureMessage());
//		}
//
//	}
//
//	private static void updatePatient() throws PatientManagementException {
//		Scanner s = new Scanner(System.in);
//		System.out.println("Enter the Patient id to update ");
//		int patient_Id = s.nextInt();
//		System.out.println("Enter the Patient's Name to update");
//		String patient_Name = s.next();
//		System.out.println("Enter the Age to update");
//		int Age = s.nextInt();
//		System.out.println("Enter the Address to update");
//		String Address = s.next();
//		System.out.println("Enter the phone_no to update");
//		long phone_no = s.nextLong();
//		System.out.println("Enter the DateOfbirth to update");
//		java.sql.Date DateOfBirth = Date.valueOf(s.next());
//		PatientVO vo = new PatientVO();
//		vo.setPatient_Id(patient_Id);
//		vo.setPatient_Name(patient_Name);
//		vo.setAge(Age);
//		vo.setAddress(Address);
//		vo.setPhone_no(phone_no);
//		vo.setDateOfBirth(DateOfBirth);
//		HospitalManagementService Hospitalservice = new HospitalManagementService();
//		PatientResponseObject obj;
//		obj = Hospitalservice.updatePatient(vo);
//		if (obj.getSuccessMessage() != null) {
//			System.out.println(obj.getSuccessMessage());
//		} else {
//			System.out.println(obj.getFailureMessage());
//		}
//
//	}
	public static void main(String[] args) throws TreatmentManagementException, TreatmentNotFoundException {

		System.out.println("Please select one of the below options");
		System.out.println("1. Add Treatment");
		System.out.println("2. Fetch Treatment by treatment id");
		System.out.println("3. Fetch Treatment by Disease");
		System.out.println("4. Update Treatment Details");
		System.out.println("5. Generate Bill");
		System.out.println("6. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			addTreatmentDetails();
			break;
		case 2:
			fetchTreatmentById();
			break;
		case 3:
			fetchTreatmentByDiseases();
			break;
		case 4:
			updateTreatmentDetails();
			break;
		case 5:
			fetchBillByIdUsingJoins();
			break;
		default:
			System.exit(0);
		}
	}

	private static void fetchBillByIdUsingJoins() throws TreatmentNotFoundException {
//		Scanner s = new Scanner(System.in);
//		System.out.println("Enter the patientId to be Fetched:");
//		Integer patient_Id = Integer.parseInt(s.next());
		HospitalManagementService Hospitalservice = new HospitalManagementService();
		TreatmentResponseObject obj =null;
		Hospitalservice.fetchTreatmentByUsingJoins();
		TreatmentVO vo = new TreatmentVO();
		RoomVO vo1 = new RoomVO();
//		vo = obj.getTreatmentvo();		
//   	System.out.println(vo1);
//		if (vo != null) {
//			System.out.println(
//					"=========================================================================================================");
//			System.out.println("patient_Id" + '\t' + "Treatment_Charge" + '\t' + "Room_Charge");
//			System.out.println(
//					"=========================================================================================================");
//			System.out.println(vo.getPatient_Id() + "                " + vo.getCharge() +"          "+ vo1.getRoom_Charge() );
//
//		}

	}

	private static void addTreatmentDetails() throws TreatmentManagementException {

		Scanner s = new Scanner(System.in);

		System.out.println("Enter the Patient_Id");
		int patient_Id = s.nextInt();
		System.out.println("Enter the Disease Name");
		String Diseases = s.next();
		System.out.println("Enter the Treatment description");
		String Treatment_description = s.next();
		System.out.println("Enter the Treatment_charge");
		double Charge = s.nextDouble();
		TreatmentVO vo = new TreatmentVO();
		vo.setPatient_Id(patient_Id);
		vo.setDiseases(Diseases);
		vo.setTreatment_description(Treatment_description);
		vo.setCharge(Charge);
		HospitalManagementService Hospitalservice = new HospitalManagementService();
		TreatmentResponseObject obj;
		obj = Hospitalservice.addTreatmentDetails(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchTreatmentById() throws TreatmentNotFoundException {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the TreatmentId to be Fetched:");
		Integer Treatment_Id = Integer.parseInt(s.next());
		TreatmentVO vo = new TreatmentVO();
		HospitalManagementService Hospitalservice = new HospitalManagementService();
		TreatmentResponseObject obj;
		obj = Hospitalservice.fetchTreatmentById(Treatment_Id);
		vo = obj.getTreatmentvo();
		if (vo != null) {
			System.out.println(
					"=========================================================================================================");
			System.out.println("patient_Id" + '\t' + "Diseases" + '\t' + "Treatment_Id" + '\t' + "Treatment_Description"
					+ "  " + '\t' + "Charge");
			System.out.println(
					"=========================================================================================================");
			System.out.println(vo.getPatient_Id() + "                " + vo.getDiseases() + "          "
					+ vo.getTreatment_Id() + "      " + vo.getTreatment_description() + "         " + vo.getCharge());

		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchTreatmentByDiseases() throws TreatmentNotFoundException {
		TreatmentDAO dao=new TreatmentDAO();
		dao.fetchTreatmentByIdUsingJoins();
		/*
		 * Scanner s = new Scanner(System.in);
		 * System.out.println("Enter the Disease to be Fetched:"); String Diseases =
		 * s.next(); List<TreatmentVO> list = new ArrayList<>();
		 * HospitalManagementService Hospitalservice = new HospitalManagementService();
		 * TreatmentResponseObject obj = null; obj =
		 * Hospitalservice.fetchTreatmentByDiseases(Diseases); System.out.println(obj);
		 * list = obj.getTreatmentList(); System.out.println(
		 * "======================================================================================================"
		 * ); System.out.println("patient_Id" + '\t' + "Diseases" + '\t' +
		 * "Treatment_Id" + '\t' + "Treatment_Description" + "  " + '\t' + "Charge"); if
		 * (!list.isEmpty() && obj.getFailureMessage() == null) { for (TreatmentVO vo :
		 * list) { System.out.println(
		 * "=========================================================================================================================================="
		 * );
		 * 
		 * System.out.println( vo.getPatient_Id() + "                " +
		 * vo.getDiseases() + "          " + vo.getTreatment_Id() + "      " +
		 * vo.getTreatment_description() + "         " + vo.getCharge()); }
		 * 
		 * } else if (list.isEmpty()) { System.out.println(obj.getFailureMessage()); }
		 */

	}

	private static void updateTreatmentDetails() throws TreatmentManagementException {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Treatment id to update ");
		int Treatment_Id = s.nextInt();
		System.out.println("Enter the  to patient id update");
		int patient_Id = s.nextInt();
		System.out.println("Enter the Disease to update");
		String Diseases = s.next();
		System.out.println("Enter the Treatment description");
		String Treatment_description = s.next();
		System.out.println("Enter the charge to update");
		double Charge = s.nextDouble();
		TreatmentVO vo = new TreatmentVO();
		vo.setTreatment_Id(Treatment_Id);
		vo.setPatient_Id(patient_Id);
		vo.setDiseases(Diseases);
		vo.setTreatment_description(Treatment_description);
		vo.setCharge(Charge);
		HospitalManagementService Hospitalservice = new HospitalManagementService();
		TreatmentResponseObject obj;
		obj = Hospitalservice.updateTreatmentDetails(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

//	public static void main(String[] args) throws RoomManagementException, RoomNotFoundException {
//
//		System.out.println("Please select one of the below options");
//		System.out.println("1. Add Room details");
//		System.out.println("2. Fetch Room by Room number");
//		System.out.println("3. Fetch Room by Room location");
//		System.out.println("4. Update Room Details");
//		System.out.println("5. Exit");
//		Scanner s = new Scanner(System.in);
//		int menuSelected = s.nextInt();
//		switch (menuSelected) {
//		case 1:
//			addRoomDetails();
//			break;
//		case 2:
//			fetchRoomByRoomNumber();
//			break;
//		case 3:
//			fetchRoomBylocation();
//			break;
//		case 4:
//			updateRoomDetails();
//			break;
//		default:
//			System.exit(0);
//		}
//	}
//
//	private static void updateRoomDetails() throws RoomManagementException {
//			Scanner s = new Scanner(System.in);
//			System.out.println("Enter the Room_NO to update ");
//			int Room_NO = s.nextInt();
//			System.out.println("Enter the Patient's Id to update");
//			int patient_Id=s.nextInt();
//			System.out.println("Enter the Room Status");
//			String Room_Status=s.next();
//			System.out.println("Enter the Room Location");
//			String Room_Location = s.next();
//			System.out.println("Enter the Room Charge");
//			double Room_Charge=s.nextDouble();
//			RoomVO vo = new RoomVO();
//			vo.setPatient_Id(patient_Id);
//			vo.setRoom_NO(Room_NO);
//			vo.setRoom_Status(Room_Status);
//			vo.setRoom_Location(Room_Location);
//			vo.setRoom_Charge(Room_Charge);
//			//System.out.println(vo);
//			HospitalManagementService Hospitalservice = new HospitalManagementService();
//			RoomResponseObject obj;
//			obj = Hospitalservice.updateRoomDetails(vo);
//			if (obj.getSuccessMessage() != null) {
//				System.out.println(obj.getSuccessMessage());
//			} else {
//				System.out.println(obj.getFailureMessage());
//			}
//
//	}
//
//	private static void fetchRoomBylocation() throws RoomNotFoundException {
//		Scanner s = new Scanner(System.in);
//		System.out.println("Enter the RoomLocation to be Fetch:");
//		String Room_Location = s.next();
//		List<RoomVO> list = new ArrayList<>();
//		HospitalManagementService Hospitalservice = new HospitalManagementService();
//		RoomResponseObject obj =null;
//		obj = Hospitalservice.fetchRoomByLocation(Room_Location);
//		list = obj.getRoomList();
//			System.out.println(
//					"==========================================================================================================================================");
//			System.out.println("patient_Id" + '\t' + "Room_NO" + '\t' + "Room_Status" + '\t' + "Room_Location" + "  "
//					+ '\t' + "Room_Charge");
//			if(!list.isEmpty()&& obj.getFailureMessage()==null) {
//				for(RoomVO vo:list)
//				{
//			System.out.println(
//					"==========================================================================================================================================");
//			System.out.println(vo.getPatient_Id() + "                " + vo.getRoom_NO() + "          "
//					+ vo.getRoom_Status() + "      " + vo.getRoom_Location() + "         " + vo.getRoom_Charge());
//
//				}
//
//		} else if(list.isEmpty()) {
//			System.out.println(obj.getFailureMessage());
//		}
//
//	}
//
//	private static void fetchRoomByRoomNumber() throws RoomManagementException, RoomNotFoundException {
//		Scanner s = new Scanner(System.in);
//		System.out.println("Enter the Room to be Fetched:");
//		Integer Room_NO = Integer.parseInt(s.next());
//		RoomVO vo = new RoomVO();
//		HospitalManagementService Hospitalservice = new HospitalManagementService();
//		RoomResponseObject obj;
//		obj = Hospitalservice.fetchRoomByRoomNumber(Room_NO);
//		vo = obj.getRoomvo();
//		if (vo != null) {
//			System.out.println(
//					"=========================================================================================================");
//			System.out.println("patient_Id" + '\t' + "Room_NO" + '\t' + "Room_Status" + '\t' + "Room_Location" + "  "
//					+ '\t' + "Room_Charge");
//			System.out.println(
//					"=========================================================================================================");
//			System.out.println(vo.getPatient_Id() + "                " + vo.getRoom_NO() + "          "
//					+ vo.getRoom_Status() + "      " + vo.getRoom_Location() + "         " + vo.getRoom_Charge());
//
//		} else {
//			System.out.println(obj.getFailureMessage());
//		}
//
//	}
//
//	private static void addRoomDetails() throws RoomManagementException {
//
//		Scanner s = new Scanner(System.in);
//
//		System.out.println("Enter the Patient_Id");
//		int patient_Id = s.nextInt();
//		System.out.println("Enter the Room number");
//		int Room_NO = s.nextInt();
//		System.out.println("Enter the Room Status");
//		String Room_Status = s.next();
//		System.out.println("Enter the Room location");
//		String Room_Location = s.next();
//		System.out.println("Enter the Room charge");
//		double Room_Charge = s.nextDouble();
//		RoomVO vo = new RoomVO();
//		vo.setPatient_Id(patient_Id);
//		vo.setRoom_NO(Room_NO);
//		vo.setRoom_Status(Room_Status);
//		vo.setRoom_Location(Room_Location);
//		vo.setRoom_Charge(Room_Charge);
//		HospitalManagementService Hospitalservice = new HospitalManagementService();
//		RoomResponseObject obj;
//		obj = Hospitalservice.addRoomDetails(vo);
//		if (obj.getSuccessMessage() != null) {
//			System.out.println(obj.getSuccessMessage());
//		} else {
//			System.out.println(obj.getFailureMessage());
//		}
//
//	}

	// Physician

//	public static void main(String[] args) throws PhysicianManagementException, PhysicianNotFoundException {
//
//		System.out.println("Please select one of the below options");
//		System.out.println("1. Add Physician details");
//		System.out.println("2. Fetch physician by physician id");
//		System.out.println("3. Fetch Physician by Name");
//		System.out.println("4. Update Physician  Details");
//		System.out.println("5. Exit");
//		Scanner s = new Scanner(System.in);
//		int menuSelected = s.nextInt();
//		switch (menuSelected) {
//		case 1:
//			addPhysicianDetails();
//			break;
//		case 2:
//			fetchPhysicainById();
//			break;
//		case 3:
//			fetchPhysicainByName();
//			break;
//		case 4:
//			updatePhysicianDetails();
//			break;
//		default:
//			System.exit(0);
//		}
//	}
//
//	private static void updatePhysicianDetails() throws PhysicianManagementException {
//
//			Scanner s = new Scanner(System.in);
//			System.out.println("Enter the Physician_Id to be update");
//			int physician_Id = s.nextInt();
//			System.out.println("Enter the Patient_Id");
//			int patient_Id = s.nextInt();
//			System.out.println("Enter the Treatement_Id");
//			int treatment_Id = s.nextInt();
//			System.out.println("Enter the physician Name");
//			String physician_Name = s.next();
//			System.out.println("Enter the Specialization");
//			String specialization = s.next();
//			System.out.println("Enter the physician_charge");
//			double physician_Charge = s.nextDouble();
//			PhysicianVO vo = new PhysicianVO();
//			vo.setPatient_Id(patient_Id);
//			vo.setTreatment_Id(treatment_Id);
//			vo.setPhysician_Id(physician_Id);
//			vo.setPhysician_Name(physician_Name);
//			vo.setSpecialization(specialization);
//			vo.setPhysician_Charge(physician_Charge);
//			HospitalManagementService Hospitalservice = new HospitalManagementService();
//			PhysicianResponseObject obj;
//			obj = Hospitalservice.updatePhysicianDetails(vo);
//			if (obj.getSuccessMessage() != null) {
//				System.out.println(obj.getSuccessMessage());
//			} else {
//				System.out.println(obj.getFailureMessage());
//			}
//		
//	}
//
//	private static void fetchPhysicainByName() throws PhysicianNotFoundException  {
//			Scanner s = new Scanner(System.in);
//			System.out.println("Enter the Physician name to be Fetch:");
//			String Physician_Name = s.next();
//			List<PhysicianVO> list = new ArrayList<>();
//			HospitalManagementService Hospitalservice = new HospitalManagementService();
//			PhysicianResponseObject obj =null;
//			obj = Hospitalservice.fetchPhysiciantByName(Physician_Name);
//			list = obj.getPhysicianList();
//				System.out.println(
//						"==========================================================================================================================================");
//				System.out.println("patient_Id" + '\t' + "Treatment_Id" + '\t' + "Physician_Id" + '\t' + "Physician_Name" + "  "
//						+ '\t' + "Specialization" + '\t'+"Physician_Charge");
//				if(!list.isEmpty()&& obj.getFailureMessage()==null) {
//					for(PhysicianVO vo:list)
//					{
//				System.out.println(
//						"==========================================================================================================================================");
//				System.out.println(vo.getPatient_Id() + "                " + vo.getTreatment_Id() + "          "
//						+ vo.getPhysician_Id() + "      " + vo.getPhysician_Name() + "         " + vo.getSpecialization()+ "        "+vo.getPhysician_Charge());
//
//					}
//
//			} else if(list.isEmpty()) {
//				System.out.println(obj.getFailureMessage());
//			}
//
//		}
//
//	private static void fetchPhysicainById() throws PhysicianNotFoundException {
//		Scanner s = new Scanner(System.in);
//		System.out.println("Enter the physician Id to be Fetched:");
//		Integer Physician_Id = Integer.parseInt(s.next());
//		PhysicianVO vo = new PhysicianVO();
//		HospitalManagementService Hospitalservice = new HospitalManagementService();
//		PhysicianResponseObject obj;
//		obj = Hospitalservice.fetchPhysicianById(Physician_Id);
//		vo = obj.getPhysicianvo();
//		if (vo != null) {
//			System.out.println(
//					"=========================================================================================================");
//			System.out.println("patient_Id" + '\t' + "Treatment_Id" + '\t' + "Physician_Id" + '\t' + "Physician_Name" + "  "
//					+ '\t' + "Specialization" + '\t'+"Physician_Charge");
//			System.out.println(
//					"=========================================================================================================");
//			System.out.println(vo.getPatient_Id() + "                " + vo.getTreatment_Id() + "          "
//					+ vo.getPhysician_Id() + "      " + vo.getPhysician_Name() + "         " + vo.getSpecialization()+ "        "+vo.getPhysician_Charge());
//
//		} else {
//			System.out.println(obj.getFailureMessage());
//		}
//
//	}
//		
//
//	private static void addPhysicianDetails() throws PhysicianManagementException {
//		Scanner s = new Scanner(System.in);
//
//		System.out.println("Enter the Patient_Id");
//		int patient_Id = s.nextInt();
//		System.out.println("Enter the Treatement_Id");
//		int treatment_Id = s.nextInt();
//		System.out.println("Enter the physician Name");
//		String physician_Name = s.next();
//		System.out.println("Enter the Specialization");
//		String specialization = s.next();
//		System.out.println("Enter the physician_charge");
//		double physician_Charge = s.nextDouble();
//		PhysicianVO vo = new PhysicianVO();
//		vo.setPatient_Id(patient_Id);
//		vo.setTreatment_Id(treatment_Id);
//		vo.setPhysician_Name(physician_Name);
//		vo.setSpecialization(specialization);
//		vo.setPhysician_Charge(physician_Charge);
//		HospitalManagementService Hospitalservice = new HospitalManagementService();
//		PhysicianResponseObject obj;
//		obj = Hospitalservice.addPhysicianDetails(vo);
//		if (obj.getSuccessMessage() != null) {
//			System.out.println(obj.getSuccessMessage());
//		} else {
//			System.out.println(obj.getFailureMessage());
//		}
//		
//	}

}
