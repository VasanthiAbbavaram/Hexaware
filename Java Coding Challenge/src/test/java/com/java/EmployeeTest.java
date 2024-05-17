package com.java.AssetManagement;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.AssetManagement.model.Employees;

public class EmployeeTest {

    @Test
    public void testToString() {
        Employees emp1 = new Employees(1, "John Doe", "HR", "john.doe@example.com", "pass123");
        String expected = "Employees [employeeId=1, name=John Doe, department=HR, email=john.doe@example.com, password=pass123]";
        assertEquals(expected, emp1.toString());
    }

    @Test
    public void testEquals() {
        Employees emp1 = new Employees(1, "John Doe", "HR", "john.doe@example.com", "pass123");
        Employees emp2 = new Employees(1, "John Doe", "HR", "john.doe@example.com", "pass123");
        Employees emp3 = new Employees(2, "Jane Doe", "IT", "jane.doe@example.com", "pass123");
        assertTrue(emp1.equals(emp2));
        assertFalse(emp1.equals(emp3));
    }

    @Test
    public void testHashCode() {
        Employees emp1 = new Employees(1, "John Doe", "HR", "john.doe@example.com", "pass123");
        Employees emp2 = new Employees(1, "John Doe", "HR", "john.doe@example.com", "pass123");
        assertEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void testGettersAndSetters() {
        Employees employee = new Employees();
        employee.setEmployeeId(1);
        employee.setName("John Doe");
        employee.setDepartment("HR");
        employee.setEmail("john.doe@example.com");
        employee.setPassword("pass123");
        assertEquals(1, employee.getEmployeeId());
        assertEquals("John Doe", employee.getName());
        assertEquals("HR", employee.getDepartment());
        assertEquals("john.doe@example.com", employee.getEmail());
        assertEquals("pass123", employee.getPassword());
    }

    @Test
    public void testConstructors() {
        Employees employee = new Employees();
        assertNotNull(employee);
        Employees emp = new Employees(1, "John Doe", "HR", "john.doe@example.com", "pass123");
        assertEquals(1, emp.getEmployeeId());
        assertEquals("John Doe", emp.getName());
        assertEquals("HR", emp.getDepartment());
        assertEquals("john.doe@example.com", emp.getEmail());
        assertEquals("pass123", emp.getPassword());
    }
}
