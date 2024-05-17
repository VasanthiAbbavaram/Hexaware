package com.java.AssetManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.AssetManagement.model.Employees;
import com.java.AssetManagement.util.DBConnUtil;
import com.java.AssetManagement.util.DBpropertyUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	Connection connection;
	PreparedStatement pst;
	
	@Override
	public List<Employees> showEmployeeDao() throws ClassNotFoundException, SQLException {
		String connStr = DBpropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "select * from Employees";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Employees> employeeList = new ArrayList<Employees>();
		Employees employees = null;
		while(rs.next()) {
			employees = new Employees();
			employees.setEmployeeId(rs.getInt("employeeId"));
			employees.setName(rs.getString("name"));
			employees.setDepartment(rs.getString("department"));
			employees.setEmail(rs.getString("email"));
			employees.setPassword(rs.getString("password"));
			
			employeeList.add(employees);
		}
		return employeeList;
	}

	@Override
	public Employees searchEmployeeDao(int empno) throws ClassNotFoundException, SQLException {
		String connStr = DBpropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "select * from Employees where employeeId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, empno);
		ResultSet rs = pst.executeQuery();
		
		Employees employees = null;
		if(rs.next()) {
			employees = new Employees();
			employees.setEmployeeId(rs.getInt("employeeId"));
			employees.setName(rs.getString("name"));
			employees.setDepartment(rs.getString("department"));
			employees.setEmail(rs.getString("email"));
			employees.setPassword(rs.getString("password"));
		}return employees;
	
	}

	@Override
	public String addEmployeeDao(Employees employees) throws ClassNotFoundException, SQLException {
		
		String connStr = DBpropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = " insert into Employees(employeeId,name,department,email,password) " + " values(?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, employees.getEmployeeId());
		pst.setString(2, employees.getName());
		pst.setString(3, employees.getDepartment());
		pst.setString(4, employees.getEmail());
		pst.setString(5, employees.getPassword());
		pst.executeUpdate();
		return "Employee Record Inserted";
	}

	@Override
	public String updateEmployeeDao(Employees employees) throws ClassNotFoundException, SQLException {
		
		Employees empFound= searchEmployeeDao(employees.getEmployeeId());
		if(empFound !=null) {
			String connStr = DBpropertyUtil.getConnectionString("db");
			connection = DBConnUtil.GetConnection(connStr);
			
			String cmd = "update Employees set name=? , department=? , email=? , password=? where employeeId=? " ;
			pst = connection.prepareStatement(cmd);
			pst.setString(1, employees.getName());
			pst.setString(2, employees.getDepartment());
			pst.setString(3, employees.getEmail());
			pst.setString(4, employees.getPassword());
			pst.setInt(5, employees.getEmployeeId());
			pst.executeUpdate();
			return "Employee Record Updated";
		}
		else {
			return "Employee Record not found";
		}
		
	}

	@Override
	public String deleteEmployeeDao(int employeeId) throws ClassNotFoundException, SQLException {
		
		Employees empFound= searchEmployeeDao(employeeId);
		if(empFound !=null) {
			String connStr = DBpropertyUtil.getConnectionString("db");
			connection = DBConnUtil.GetConnection(connStr);
			
			String cmd = "delete from Employees where employeeId=? " ;
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, employeeId);
			pst.executeUpdate();
			return "Employee Record Deleted";
		}
		else {
			return "Employee Record not found";
		}
	}

}
