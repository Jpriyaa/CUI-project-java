package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.exception.PatientManagementException;
import com.demo.exception.PatientNotFoundException;
import com.demo.vo.PatientVO;

public class PatientDAO {
	public boolean addPatientDetails(PatientVO vo) throws PatientManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "jp@123";
		String url = "jdbc:mysql://localhost:3306/hospitalmanagement";
		Connection connection = null;
		PreparedStatement pa = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String sql = "INSERT INTO patient_Details (patient_Name,Age,Address,phone_no,DateOfBirth) VALUES (?,?,?,?,?)";
			pa = connection.prepareStatement(sql);
			pa.setString(1, vo.getPatient_Name());
			pa.setInt(2, vo.getAge());
			pa.setString(3, vo.getAddress());
			pa.setLong(4, vo.getPhone_no());
			pa.setDate(5, vo.getDateOfBirth());
			pa.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			throw new PatientManagementException("Error when adding the patient Details" + e.getMessage());
		} finally {
			try {
				pa.close();
				connection.close();
			} catch (SQLException e) {
				throw new PatientManagementException("Error when adding the patient Details" + e.getMessage());
			}
		}
		return flag;
	}

	public PatientVO fetchPatientById(int patient_Id) throws PatientNotFoundException {
		String userName = "root";
		String password = "jp@123";
		String url = "jdbc:mysql://localhost:3306/hospitalManagement";
		Connection connection = null;
		PreparedStatement pa = null;
		ResultSet rs = null;
		PatientVO vo = new PatientVO();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select*from Patient_Details where patient_Id=?";
			pa = connection.prepareStatement(query);
			pa.setInt(1, patient_Id);
			rs = pa.executeQuery();
			while (rs.next()) {
				vo.setPatient_Id(rs.getInt("patient_Id"));
				vo.setPatient_Name(rs.getString("patient_Name"));
				vo.setAge(rs.getInt("Age"));
				vo.setAddress(rs.getString("Address"));
				vo.setPhone_no(rs.getLong("phone_no"));
				vo.setDateOfBirth(rs.getDate("DateOfBirth"));
				// System.out.println(vo);
			}

		} catch (SQLException e) {
			throw new PatientNotFoundException("Given Patient id not exist in database");
		} finally {
			try {
				pa.close();
				connection.close();
			} catch (SQLException e) {
				throw new PatientNotFoundException("Given Patient id not exist in database");
			}
		}
		return vo;
	}

	public List<PatientVO> fetchPatientByName(String patient_Name) throws PatientNotFoundException {
		String userName = "root";
		String password = "jp@123";
		String url = "jdbc:mysql://localhost:3306/hospitalManagement";
		Connection connection = null;
		PreparedStatement pa = null;
		ResultSet rs = null;
		PatientVO vo ;
		List<PatientVO> list = new ArrayList<>();
		
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select*from Patient_Details where patient_Name = ? ";
			pa = connection.prepareStatement(query);
			pa.setString(1, patient_Name);
			rs = pa.executeQuery();
			while (rs.next()) {
                vo=new PatientVO();
				vo.setPatient_Id(rs.getInt("patient_Id"));
				vo.setPatient_Name(rs.getString("patient_Name"));
				vo.setAge(rs.getInt("Age"));
				vo.setAddress(rs.getString("Address"));
				vo.setPhone_no(rs.getLong("phone_no"));
				vo.setDateOfBirth(rs.getDate("DateOfBirth"));
				list.add(vo);
				//System.out.println(list);
			}
			
			} catch (SQLException e) {
			throw new PatientNotFoundException("Given Patient id not exist in database");
		} finally {
			try {
				pa.close();
				connection.close();
			} catch (SQLException e) {
				throw new PatientNotFoundException("Given Patient id not exist in database");
			}
		}
		return list;
	}

	public boolean updatePatient(PatientVO vo) throws PatientManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "jp@123";
		String url = "jdbc:mysql://localhost:3306/hospitalmanagement";
		Connection connection = null;
		PreparedStatement pa = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String sql = "update Patient_Details set patient_Name=?,Age=?,Address=?,phone_no=?,DateOfBirth=? where Patient_Id = ?";
			pa = connection.prepareStatement(sql);
			pa.setString(1, vo.getPatient_Name());
			pa.setInt(2, vo.getAge());
			pa.setString(3, vo.getAddress());
			pa.setLong(4, vo.getPhone_no());
			pa.setDate(5, vo.getDateOfBirth());
			pa.setInt(6, vo.getPatient_Id());
			pa.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			throw new PatientManagementException("Error when updating the patient Details" + e.getMessage());
		} finally {
			try {
				pa.close();
				connection.close();
			} catch (SQLException e) {
				throw new PatientManagementException("Error when updating the patient Details" + e.getMessage());
			}
		}
		return flag;
	}

}