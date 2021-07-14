package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.exception.TreatmentManagementException;
import com.demo.exception.TreatmentNotFoundException;
import com.demo.vo.RoomVO;
import com.demo.vo.TreatmentVO;


public class TreatmentDAO {
	public boolean addTreatmentDetails(TreatmentVO vo) throws TreatmentManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "jp@123";
		String url = "jdbc:mysql://localhost:3306/hospitalmanagement";
		Connection connection = null;
		PreparedStatement pa = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String sql = "INSERT INTO Treatment_Details (patient_Id,Diseases,Treatment_description,Treatment_charge) VALUES (?,?,?,?)";
			pa = connection.prepareStatement(sql);
			pa.setInt(1, vo.getPatient_Id());
			pa.setString(2, vo.getDiseases());
			pa.setString(3, vo.getTreatment_description());
			pa.setDouble(4, vo.getCharge());
			pa.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			throw new TreatmentManagementException("Error when adding the Treatment Details" + e.getMessage());
		} finally {
			try {
				pa.close();
				connection.close();
			} catch (SQLException e) {
				throw new TreatmentManagementException("Error when adding the Treatment Details" + e.getMessage());
			}
		}
		return flag;
	}
	public TreatmentVO fetchTreatmentById(int Treatment_Id) throws TreatmentNotFoundException {
		String userName = "root";
		String password = "jp@123";
		String url = "jdbc:mysql://localhost:3306/hospitalManagement";
		Connection connection = null;
		PreparedStatement pa = null;
		ResultSet rs = null;
		TreatmentVO vo = new TreatmentVO();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select*from Treatment_Details where Treatment_Id=?";
			pa = connection.prepareStatement(query);
			pa.setInt(1, Treatment_Id);
			rs = pa.executeQuery();
			while (rs.next()) {
				vo.setPatient_Id(rs.getInt("patient_Id"));
				vo.setDiseases(rs.getString("Diseases"));
				vo.setTreatment_Id(rs.getInt("Treatment_Id"));
				vo.setTreatment_description(rs.getString("Treatment_description"));
				vo.setCharge(rs.getDouble("Treatment_charge"));
				System.out.println(vo);
			}

		} catch (SQLException e) {
			throw new TreatmentNotFoundException("Given Treatment id not exist in database");
		} finally {
			try {
				pa.close();
				connection.close();
			} catch (SQLException e) {
				throw new TreatmentNotFoundException("Given Treatment id not exist in database");
			}
		}
		return vo;
	}
	public List<TreatmentVO> fetchTreatmentByDisease(String Diseases) throws TreatmentNotFoundException {
		String userName = "root";
		String password = "jp@123";
		String url = "jdbc:mysql://localhost:3306/hospitalManagement";
		Connection connection = null;
		PreparedStatement pa = null;
		ResultSet rs = null;
		TreatmentVO vo ;
		List<TreatmentVO> list = new ArrayList<>();
		
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from Treatment_Details where Diseases = ? ";
			pa = connection.prepareStatement(query);
			pa.setString(1, Diseases);
			rs = pa.executeQuery();
			while (rs.next()) {
                vo=new TreatmentVO();
				vo.setPatient_Id(rs.getInt("patient_Id"));
				vo.setDiseases(rs.getString("Diseases"));
				vo.setTreatment_Id(rs.getInt("Treatment_Id"));
				vo.setTreatment_description(rs.getString("Treatment_description"));
				vo.setCharge(rs.getDouble("Treatment_charge"));
				list.add(vo);
				System.out.println(list);
			}
			} catch (SQLException e) {
			throw new TreatmentNotFoundException("Given Treatment id not exist in database");
		} finally {
			try {
				pa.close();
				connection.close();
			} catch (SQLException e) {
				throw new TreatmentNotFoundException("Given Treatment id not exist in database");
			}
		}
		return list;
	}

	public boolean updateTreatmentDetails(TreatmentVO vo) throws TreatmentManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "jp@123";
		String url = "jdbc:mysql://localhost:3306/hospitalmanagement";
		Connection connection = null;
		PreparedStatement pa = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String sql = "update Treatment_Details set patient_Id=?, Diseases=?, Treatment_description=?,Treatment_charge=? where Treatment_Id = ?";
			pa = connection.prepareStatement(sql);
			pa.setInt(1, vo.getPatient_Id());
			pa.setString(2, vo.getDiseases());
			pa.setString(3, vo.getTreatment_description());
			pa.setDouble(4, vo.getCharge());
			pa.setInt(5, vo.getTreatment_Id());
			pa.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			throw new TreatmentManagementException("Error when updating the Treatment Details" + e.getMessage());
		} finally {
			try {
				pa.close();
				connection.close();
			} catch (SQLException e) {
				throw new TreatmentManagementException("Error when updating the Treatment Details" + e.getMessage());
			}
		}
		return flag;
	}
	public void fetchTreatmentByIdUsingJoins() throws TreatmentNotFoundException {
		String userName = "root";
		String password = "jp@123";
		String url = "jdbc:mysql://localhost:3306/hospitalManagement";
		Connection connection = null;
		PreparedStatement pa = null;
		ResultSet rs = null;
		TreatmentVO vo = new TreatmentVO();
		RoomVO vo1 =new RoomVO();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select t.patient_Id,t.Treatment_charge,r.Room_Charge from Treatment_Details as t left join Room_Details as r on t.patient_Id=r.patient_Id ";
			pa = connection.prepareStatement(query);
			
			rs = pa.executeQuery();
			while (rs.next()) {
				vo.setPatient_Id(rs.getInt("patient_Id"));
				vo.setCharge(rs.getDouble("Treatment_charge"));
				
				vo1.setRoom_Charge(rs.getDouble("Room_Charge"));
				
				System.out.println(
						"=========================================================================================================");
				System.out.println("patient_Id" + '\t' + "Treatment_Charge" + '\t' + "Room_Charge");
				System.out.println(
						"=========================================================================================================");
				System.out.println(vo.getPatient_Id() + "                " + vo.getCharge() +"          "+ vo1.getRoom_Charge() );

			}

		} catch (SQLException e) {
			throw new TreatmentNotFoundException("Given patient id not exist in database");
		} finally {
			try {
				pa.close();
				connection.close();
			} catch (SQLException e) {
				throw new TreatmentNotFoundException("Given patient id not exist in database");
			}
		}
		
	}

}
