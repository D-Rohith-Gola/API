package com.testdocker1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.testdocker1.dao.TestDAOInterface;
import com.testdocker1.entity.Employee;
@Service
@Transactional
public class TestService implements TestServiceInterface {
	
	@Autowired
	private TestDAOInterface dao;

	@Override
	public String createService(Employee ee) {
		dao.save(ee);
		return "record created ";
	}

	@Override
	// @Cacheable(value = "employees")
	@CacheEvict(value = "employees")
	public List<Employee> getAllService() {
		System.out.println("Fetching from MySQL...");
		return dao.findAll();
	}
	
	@Cacheable(value = "employee" , key = "#email")
	public Employee getEmpById(String email) {
		Optional<Employee> ee= dao.findById(email);
		return ee.get();
	}

}






