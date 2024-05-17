package com.java.AssetManagement.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.AssetManagement.dao.EmployeeDao;
import com.java.AssetManagement.dao.EmployeeDaoImpl;

public class EmployDeleteMain {

	public static void main(String[] args) {
		
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee no : ");
		empno=sc.nextInt();
		EmployeeDao dao = new EmployeeDaoImpl();
		try {
			System.out.println(dao.deleteEmployeeDao(empno));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
