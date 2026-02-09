package com.synechronepuneproducer.service;

import java.util.List;

import com.synechronepuneproducer.entity.Employee;

public interface MyServiceInterface {



	List<Employee> getAllEmployees();

	Employee getEmployeeById(String id);

	Employee saveEmployee(Employee employee);

	Employee updateEmployee(String id, Employee employee);

	void deleteEmployee(String id);

}
