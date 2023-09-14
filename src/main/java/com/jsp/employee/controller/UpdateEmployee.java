package com.jsp.employee.controller;

import com.jsp.employee.dto.Employee;
import com.jsp.employee.service.EmployeeService;

public class UpdateEmployee {
	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeService();
		Employee el =   employeeService.updateEmployee(1,"kanishk7777@gmail.com");
		
		System.out.println(el.getEmail());
	}
}
