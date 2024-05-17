package com.java.AssetManagement.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.AssetManagement.model.Employees;

public interface EmployeeDao {

	List<Employees> showEmployeeDao() throws ClassNotFoundException, SQLException;
	Employees searchEmployeeDao(int empno) throws ClassNotFoundException, SQLException;
	String addEmployeeDao(Employees employee) throws ClassNotFoundException, SQLException;
	String updateEmployeeDao(Employees employee) throws ClassNotFoundException, SQLException;
	String deleteEmployeeDao(int employeeId) throws ClassNotFoundException, SQLException ;
}
