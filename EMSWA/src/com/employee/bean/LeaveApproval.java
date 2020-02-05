package com.employee.bean;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.employee.util.DataBaseUtility;

public class LeaveApproval {
	
	private String appid;
	private String rejid;


	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
		
	public String getRejid() {
		return rejid;
	}

	public void setRejid(String rejid) {
		this.rejid = rejid;
	}
	
	
	public void Approve(String userid) {
		try {
			Connection connection = null;
			connection = DataBaseUtility.getConnection();
			Statement statement = connection.createStatement();
			String app = "approved";
			System.out.println(appid);
			statement.executeUpdate(" update leave_sheet set approved =  '"+app+"' where emp_id = '"+userid+"' ");
			System.out.println("updated as approved");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Reject(String userid) {
		try {
			Connection connection = null;
			connection = DataBaseUtility.getConnection();
			Statement statement = connection.createStatement();
			String rej = "rejected";
			statement.executeUpdate(" update leave_sheet set approved =  '"+rej+"' where emp_id = '"+userid+"' ");
			System.out.println("updated as rejected");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

