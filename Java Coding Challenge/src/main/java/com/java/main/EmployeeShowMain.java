package com.java.AssetManagement.main;

import java.sql.SQLException;
import java.util.List;

import com.java.AssetManagement.dao.EmployeeDao;
import com.java.AssetManagement.dao.EmployeeDaoImpl;
import com.java.AssetManagement.model.Employees;

public class EmployeeShowMain {

	public static void main(String[] args) {
		
		EmployeeDao dao = new EmployeeDaoImpl();
		try {
			List<Employees> employeeList = dao.showEmployeeDao();
			for (Employees employees : employeeList) {
				System.out.println(employees);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
