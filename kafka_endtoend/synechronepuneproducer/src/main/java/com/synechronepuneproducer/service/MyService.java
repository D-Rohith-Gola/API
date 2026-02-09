package com.synechronepuneproducer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechronepuneproducer.dao.MyDAOInterface;
import com.synechronepuneproducer.entity.Employee;

@Service
public class MyService implements MyServiceInterface {
	
	@Autowired
	private MyDAOInterface mDao;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return mDao.findAll();
	}

	@Override
	public Employee getEmployeeById(String id) {
		
		return mDao.getById(id);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		mDao.save(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(String id, Employee employee) {
		employee.setEmail(id);
		mDao.saveAndFlush(employee);
		return null;
	}

	@Override
	public void deleteEmployee(String id) {
		mDao.deleteById(id);
		
	}

	

}
