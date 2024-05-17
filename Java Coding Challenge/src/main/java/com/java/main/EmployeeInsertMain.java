package com.java.AssetManagement.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.AssetManagement.dao.EmployeeDao;
import com.java.AssetManagement.dao.EmployeeDaoImpl;
import com.java.AssetManagement.model.Employees;

public class EmployeeInsertMain {

	public static void main(String[] args) {
		Employees employee = new Employees();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id ");
		employee.setEmployeeId(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter name ");
		employee.setName(sc.nextLine());
		System.out.println("Enter department ");
		employee.setDepartment(sc.nextLine());
		System.out.println("Enter email ");
		employee.setEmail(sc.nextLine());
		System.out.println("Enter password ");
		employee.setPassword(sc.nextLine());
		
		EmployeeDao dao = new EmployeeDaoImpl();
		try {
			System.out.println(dao.addEmployeeDao(employee));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
