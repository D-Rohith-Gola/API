package com.dockerTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dockerTest.entity.DockerTestEntity;
import com.dockerTest.service.ServiceInterface;

@RestController
@RequestMapping("api/v1/testDocker")
public class Controller {
	
	@Autowired
	ServiceInterface serviceInterface;

//	@GetMapping
//	private String testDocker() {
//		return "Test Docker Successful";
//	}
	
	@PostMapping
	public String createAccount(@RequestBody DockerTestEntity dte) {
		return serviceInterface.createAccountService(dte);
	}
	@GetMapping("/{e}")
	public String viewAccount(@PathVariable("e") String email) {
		return serviceInterface.viewAccountService(email);
	}
	@PutMapping("/{e}")
	public String editAccount(@PathVariable("e") String email,@RequestBody DockerTestEntity dte) {
		return serviceInterface.editAccountService(email,dte);
	}
	@DeleteMapping("/{e}")
	public String deleteAccount(@PathVariable("e") String email) {
		return serviceInterface.deleteAccountService(email);
	}
	// Get all Details
    @GetMapping()
    public List<DockerTestEntity> viewAllAccount() {
		return serviceInterface.getAllAccount();
    }
}
