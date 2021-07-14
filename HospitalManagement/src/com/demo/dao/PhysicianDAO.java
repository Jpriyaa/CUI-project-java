package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.exception.PhysicianManagementException;
import com.demo.exception.PhysicianNotFoundException;
import com.demo.exception.RoomManagementException;
import com.demo.exception.RoomNotFoundException;
import com.demo.exception.TreatmentNotFoundException;
import com.demo.vo.PhysicianVO;
import com.demo.vo.RoomVO;

public class PhysicianDAO {
	public boolean addPhysicianDetails(PhysicianVO vo) throws PhysicianManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "jp@123";
		String url = "jdbc:mysql://localhost:3306/hospitalmanagement";
		Connection connection = null;
		PreparedStatement pa = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String sql = "INSERT INTO Physician (patient_Id,Treatment_Id,Physician_Name,Specialization,Physician_Charge) VALUES (?,?,?,?,?)";
			pa = connection.prepareStatement(sql);
			pa.setInt(1, vo.getPatient_Id());
			pa.setInt(2, vo.getTreatment_Id());
			pa.setString(3, vo.getPhysician_Name());
			pa.setString(4, vo.getSpecialization());
			pa.setDouble(5,vo.getPhysician_Charge());
			pa.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			throw new PhysicianManagementException("Error when adding the Physician Details" + e.getMessage());
		} finally {
			try {
				pa.close();
				connection.close();
			} catch (SQLException e) {
				throw new PhysicianManagementException("Error when adding the Pysician Details" + e.getMessage());
			}
		}
		return flag;
	}
	public PhysicianVO fetchPhysicianById(int Physician_Id) throws PhysicianNotFoundException {
		String userName = "root";
		String password = "jp@123";
		String url = "jdbc:mysql://localhost:3306/hospitalManagement";
		Connection connection = null;
		PreparedStatement pa = null;
		ResultSet rs = null;
		PhysicianVO vo = new PhysicianVO();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select*from Physician where Physician_Id=?";
			pa = connection.prepareStatement(query);
			pa.setInt(1, Physician_Id);
			rs = pa.executeQuery();
			while (rs.next()) {
				vo.setPatient_Id(rs.getInt("patient_Id"));
				vo.setTreatment_Id(rs.getInt("Treatment_Id"));
				vo.setPhysician_Id(rs.getInt("Physician_Id"));
				vo.setPhysician_Name(rs.getString("Physician_Name"));
				vo.setSpecialization(rs.getString("Specialization"));
				vo.setPhysician_Charge(rs.getDouble("Physician_Charge"));
			}

		} catch (SQLException e) {
			throw new PhysicianNotFoundException("Given Treatment id not exist in database");
		} finally {
			try {
				pa.close();
				connection.close();
			} catch (SQLException e) {
				throw new PhysicianNotFoundException("Given Treatment id not exist in database");
			}
		}
		return vo;
	}
	public List<PhysicianVO> fetchPhysicianByName(String Physician_Name) throws PhysicianNotFoundException {
		String userName = "root";
		String password = "jp@123";
		String url = "jdbc:mysql://localhost:3306/hospitalManagement";
		Connection connection = null;
		PreparedStatement pa = null;
		ResultSet rs = null;
		PhysicianVO vo ;
		List<PhysicianVO> list = new ArrayList<>();
		
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select*from Physician where Physician_Name = ? ";
			pa = connection.prepareStatement(query);
			pa.setString(1,Physician_Name);
			rs = pa.executeQuery();
			while (rs.next()) {
                vo=new PhysicianVO();
                vo.setPatient_Id(rs.getInt("patient_Id"));
				vo.setTreatment_Id(rs.getInt("Treatment_Id"));
				vo.setPhysician_Id(rs.getInt("Physician_Id"));
				vo.setPhysician_Name(rs.getString("Physician_Name"));
				vo.setSpecialization(rs.getString("Specialization"));
				vo.setPhysician_Charge(rs.getDouble("Physician_Charge"));
				list.add(vo);
			}
			
			} catch (SQLException e) {
			throw new PhysicianNotFoundException("Given Room location not exist in database");
		} finally {
			try {
				pa.close();
				connection.close();
			} catch (SQLException e) {
				throw new PhysicianNotFoundException("Given Room location not exist in database");
			}
		}
		return list;
	}
	public boolean updatePhysicianDetails(PhysicianVO vo) throws PhysicianManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "jp@123";
		String url = "jdbc:mysql://localhost:3306/hospitalmanagement";
		Connection connection = null;
		PreparedStatement pa = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String sql = "update Physician set patient_Id=?,Treatment_Id=?,Physician_Name=?,Specialization=?,Physician_Charge=? where Physician_Id =?";
			pa = connection.prepareStatement(sql);
			pa.setInt(1, vo.getPatient_Id());
			pa.setInt(2, vo.getTreatment_Id());
			pa.setString(3, vo.getPhysician_Name());
			pa.setString(4, vo.getSpecialization());
			pa.setDouble(5,vo.getPhysician_Charge());
			pa.setInt(6, vo.getPhysician_Id());
			pa.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			throw new PhysicianManagementException("Error when updating the Physician Details" + e.getMessage());
		} finally {
			try {
				pa.close();
				connection.close();
			} catch (SQLException e) {
				throw new PhysicianManagementException("Error when updating the Physician Details" + e.getMessage());
			}
		}
		return flag;
	}
}
