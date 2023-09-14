package com.jsp.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.employee.dto.Employee;
import com.mysql.cj.Query;

public class EmployeeDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kanishk");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	EntityTransaction entityTransaction = entityManager.getTransaction();

	Employee employee = new Employee();
	
	
	//save employee
	public Employee saveEmployee(Employee employee) {

		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;

	}
	//get employee
	public Employee getEmployee(int id) {

		Employee employee = entityManager.find(Employee.class, 1);
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		System.out.println(employee.getEmail());
		System.out.println(employee.getCno());
		return employee;
	}
	//delete employee
	public boolean deleteEmployee(int id) {

		Employee employee = entityManager.find(Employee.class, 1);

		if (employee != null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
			return true;
		} else {
			System.out.println("NOT DELETED");
			return false;
		}

	}
	
	//update employee
	public Employee updateEmployee(Employee employee) {
		if (employee != null) {

			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
		}
		return employee;
	}
	
	//getall employee
	public List<Employee> getAll() {

		String sql = "SELECT e FROM Employee e";
		
		javax.persistence.Query query = entityManager.createQuery(sql);
		List<Employee>employees = query.getResultList();
		return employees;
		

//		List<Employee> employees = entityManager.createQuery(sql, Employee.class).getResultList();
		
		
	}

}
