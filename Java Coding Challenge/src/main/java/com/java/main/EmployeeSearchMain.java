package com.java.AssetManagement.main;

import java.util.Scanner;
import java.sql.SQLException;
import com.java.AssetManagement.dao.EmployeeDao;
import com.java.AssetManagement.dao.EmployeeDaoImpl;
import com.java.AssetManagement.model.Employees;

public class EmployeeSearchMain {
	
	public static void main(String[] args) {
		
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee no : ");
		empno=sc.nextInt();
		EmployeeDao dao = new EmployeeDaoImpl();
		try {
			Employees employee = dao.searchEmployeeDao(empno);
			if(employee != null) {
				System.out.println(employee);
			}
			else {
				System.out.println("Record Not Found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
