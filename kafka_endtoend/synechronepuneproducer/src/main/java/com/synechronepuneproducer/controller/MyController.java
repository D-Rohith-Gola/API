package com.synechronepuneproducer.controller;

import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synechronepuneproducer.entity.Employee;
import com.synechronepuneproducer.service.MyServiceInterface;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/employees")
public class MyController {
	
	@Autowired
	private MyServiceInterface service;
	
	
	// Get all employees
    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    @Operation(
    	    summary = "Get user by ID",
    	    description = "Fetches complete user details using the user ID"
    	)
   
   /* public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = service.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK); // 200 OK
    }*/
    
    public UserListResponse getAllEmployees() {
        List<Employee> employees = service.getAllEmployees();
        if(employees.size()>0) {
        	Properties props = new Properties();
            props.put("bootstrap.servers", "localhost:9092");
            props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

            Producer<String, String> producer = new KafkaProducer<>(props);

           
                producer.send(new ProducerRecord<>("decembertopic", "message-", "no of employee -" + employees.size()+" found"));
          

            producer.close();
        }
        return new UserListResponse(employees); // 200 OK
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        Employee employee= service.getEmployeeById(id);
                if(employee!=null) {
                	return new ResponseEntity<>(employee, HttpStatus.OK); // 200 OK
                }
                else{
                	return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
                }
    }

    // Create a new employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = service.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED); // 201 Created
    }

    // Update an employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        try {
            Employee updatedEmployee = service.updateEmployee(id, employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK); // 200 OK
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

    // Delete an employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
        try {
            service.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }
	
	
}
