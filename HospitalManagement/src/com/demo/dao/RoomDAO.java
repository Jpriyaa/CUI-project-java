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
import com.demo.exception.RoomManagementException;
import com.demo.exception.RoomNotFoundException;
import com.demo.vo.PatientVO;
import com.demo.vo.RoomVO;

public class RoomDAO {
	public boolean addRoomDetails(RoomVO vo) throws RoomManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "jp@123";
		String url = "jdbc:mysql://localhost:3306/hospitalmanagement";
		Connection connection = null;
		PreparedStatement pa = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String sql = "INSERT INTO Room_Details (patient_Id,Room_No,Room_Status,Room_Location,Room_Charge) VALUES (?,?,?,?,?)";
			pa = connection.prepareStatement(sql);
			pa.setInt(1, vo.getPatient_Id());
			pa.setInt(2, vo.getRoom_NO());
			pa.setString(3, vo.getRoom_Status());
			pa.setString(4, vo.getRoom_Location());
			pa.setDouble(5, vo.getRoom_Charge());
			pa.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			throw new RoomManagementException("Error when adding the Room Details" + e.getMessage());
		} finally {
			try {
				pa.close();
				connection.close();
			} catch (SQLException e) {
				throw new RoomManagementException("Error when adding the Room Details" + e.getMessage());
			}
		}
		return flag;
	}
	public RoomVO fetchRoomByRoomNumber(int Room_NO) throws RoomNotFoundException {
		String userName = "root";
		String password = "jp@123";
		String url = "jdbc:mysql://localhost:3306/hospitalManagement";
		Connection connection = null;
		PreparedStatement pa = null;
		ResultSet rs = null;
		RoomVO vo = new RoomVO();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select*from Room_Details where Room_NO=?";
			pa = connection.prepareStatement(query);
			pa.setInt(1, Room_NO);
			rs = pa.executeQuery();
			while (rs.next()) {
				vo.setPatient_Id(rs.getInt("patient_Id"));
				vo.setRoom_NO(rs.getInt("Room_NO"));
				vo.setRoom_Status(rs.getString("Room_Status"));
				vo.setRoom_Location(rs.getString("Room_Location"));
				vo.setRoom_Charge(rs.getDouble("Room_Charge"));
				// System.out.println(vo);
			}

		} catch (SQLException e) {
			throw new RoomNotFoundException("Given Room id not exist in database");
		} finally {
			try {
				pa.close();
				connection.close();
			} catch (SQLException e) {
				throw new RoomNotFoundException("Given Room id not exist in database");
			}
		}
		return vo;
	}
	public List<RoomVO> fetchRoomByLocation(String Room_Location) throws RoomNotFoundException {
		String userName = "root";
		String password = "jp@123";
		String url = "jdbc:mysql://localhost:3306/hospitalManagement";
		Connection connection = null;
		PreparedStatement pa = null;
		ResultSet rs = null;
		RoomVO vo ;
		List<RoomVO> list = new ArrayList<>();
		
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select*from Room_Details where Room_Location = ? ";
			pa = connection.prepareStatement(query);
			pa.setString(1,Room_Location);
			rs = pa.executeQuery();
			while (rs.next()) {
                vo=new RoomVO();
                vo.setPatient_Id(rs.getInt("patient_Id"));
				vo.setRoom_NO(rs.getInt("Room_NO"));
				vo.setRoom_Status(rs.getString("Room_Status"));
				vo.setRoom_Location(rs.getString("Room_Location"));
				vo.setRoom_Charge(rs.getDouble("Room_Charge"));
				list.add(vo);
			}
			
			} catch (SQLException e) {
			throw new RoomNotFoundException("Given Room location not exist in database");
		} finally {
			try {
				pa.close();
				connection.close();
			} catch (SQLException e) {
				throw new RoomNotFoundException("Given Room location not exist in database");
			}
		}
		return list;
	}
	public boolean updateRoomDetails(RoomVO vo) throws RoomManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "jp@123";
		String url = "jdbc:mysql://localhost:3306/hospitalmanagement";
		Connection connection = null;
		PreparedStatement pa = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String sql = "update Room_Details set patient_Id=?, Room_Status=?, Room_Location=?, Room_Charge=? where Room_NO =?";
			pa = connection.prepareStatement(sql);
			pa.setInt(1, vo.getPatient_Id());
			pa.setString(2, vo.getRoom_Status());
			pa.setString(3, vo.getRoom_Location());
			pa.setDouble(4, vo.getRoom_Charge());
			pa.setInt(5, vo.getRoom_NO());
			pa.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			throw new RoomManagementException("Error when updating the Room Details" + e.getMessage());
		} finally {
			try {
				pa.close();
				connection.close();
			} catch (SQLException e) {
				throw new RoomManagementException("Error when updating the Room Details" + e.getMessage());
			}
		}
		return flag;
	}

}
