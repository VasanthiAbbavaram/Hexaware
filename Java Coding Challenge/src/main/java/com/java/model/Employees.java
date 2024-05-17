package com.java.AssetManagement.model;

import java.util.Objects;

public class Employees {

	private int employeeId;
	private String name;
	private String department;
	private String email;
	private String password;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employees(int employeeId, String name, String department, String email, String password) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", name=" + name + ", department=" + department + ", email="
				+ email + ", password=" + password + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(department, email, employeeId, name, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employees other = (Employees) obj;
		return Objects.equals(department, other.department) && Objects.equals(email, other.email)
				&& employeeId == other.employeeId && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password);
	}
	
}
