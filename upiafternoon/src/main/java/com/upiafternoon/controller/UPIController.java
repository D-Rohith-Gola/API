package com.upiafternoon.controller;

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

import com.upiafternoon.entity.Account;
import com.upiafternoon.service.UPIServiceInterface;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/v1/upi")
public class UPIController {
	
	//private UPIServiceInterface uService = new UPIService();
	
	@Autowired
	private UPIServiceInterface uService;
	
	//CRUD
	@PostMapping
	@Operation(
    	    summary = "Create Account",
    	    description = "Create Account"
    	)
	public String createAccount(@RequestBody Account ac) {
		return uService.createAccountService(ac);
	}
	@GetMapping("/{e}")
	@Operation(
    	    summary = "Get account details by email",
    	    description = "Fetches complete account details using the email ID"
    	)
	public String viewAccount(@PathVariable("e") String email) {
		return uService.viewAccountService(email);
	}
	@PutMapping("/{e}")
	@Operation(
    	    summary = "Edit account details by email",
    	    description = "Edit account details using the email ID"
    	)
	public String editAccount(@PathVariable("e") String email,@RequestBody Account ac) {
		return uService.editAccountService(email,ac);
	}
	@DeleteMapping("/{e}")
	@Operation(
    	    summary = "Delete Account by Email",
    	    description = "Delete complete account details using the email ID"
    	)
	public String deleteAccount(@PathVariable("e") String email) {
		return uService.deleteAccountService(email);
	}
	// Get all Details
    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    @Operation(
    	    summary = "Get all account details",
    	    description = "Fetches complete account details"
    	)
    public AccountsListResponse viewAllAccount() {
		return new AccountsListResponse(uService.getAllAccount());
    }
}
