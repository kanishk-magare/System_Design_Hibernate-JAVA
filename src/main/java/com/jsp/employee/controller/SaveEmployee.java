package com.jsp.employee.controller;

import com.jsp.employee.dto.Employee;
import com.jsp.employee.service.EmployeeService;

public class SaveEmployee {
	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeService();
		Employee employee = new Employee();
		
		employee.setId(4);
		employee.setName("xyz");
		employee.setEmail("xyz22@gmail.com");
		employee.setCno(9326598741l);
		
		employeeService.saveEmployee(employee);
	}
}
