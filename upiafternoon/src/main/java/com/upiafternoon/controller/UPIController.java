package com.upiafternoon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upiafternoon.entity.Account;
import com.upiafternoon.service.UPIServiceInterface;

@RestController
@RequestMapping("api/v1/upi")
public class UPIController {
	
	//private UPIServiceInterface uService = new UPIService();
	
	@Autowired
	private UPIServiceInterface uService;
	
	//CRUD
	@PostMapping
	public String createAccount(@RequestBody Account ac) {
		return uService.createAccountService(ac);
	}
	@GetMapping("/{e}")
	public String viewAccount(@PathVariable("e") String email) {
		return uService.viewAccountService(email);
	}
	@PutMapping("/{e}")
	public String editAccount(@PathVariable("e") String email,@RequestBody Account ac) {
		return uService.editAccountService(email,ac);
	}
	@DeleteMapping("/{e}")
	public String deleteAccount(@PathVariable("e") String email) {
		return uService.deleteAccountService(email);
	}
}
