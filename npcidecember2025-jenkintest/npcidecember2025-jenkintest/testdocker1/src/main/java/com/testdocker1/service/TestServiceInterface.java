package com.testdocker1.service;

import java.util.List;

import com.testdocker1.entity.Employee;

public interface TestServiceInterface {

	String createService(Employee ee);

	List<Employee> getAllService();

}
