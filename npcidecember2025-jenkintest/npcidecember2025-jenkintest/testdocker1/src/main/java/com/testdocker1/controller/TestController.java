package com.testdocker1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testdocker1.entity.Employee;
import com.testdocker1.service.TestServiceInterface;

@RestController
@RequestMapping("api/v1/testDocker")
public class TestController {
	
	@Autowired
	private TestServiceInterface service;
	
	@GetMapping
	public List<Employee> getAll() {
		return service.getAllService();
	}
	
	@PostMapping
	public String create(@RequestBody Employee ee) {
		return service.createService(ee);
	}
}
