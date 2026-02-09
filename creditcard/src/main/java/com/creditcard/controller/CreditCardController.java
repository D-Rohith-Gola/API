package com.creditcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.entity.Card;
import com.creditcard.service.CreditCardServiceInterface;

@RestController //this line shows it is a controller layer
@RequestMapping("api/v1/creditcard")
public class CreditCardController {
	
	@Autowired
	private CreditCardServiceInterface cService;
	
	@PostMapping //create resource
	public String createProfile(@RequestBody Card cc) {
		//return "profile created "+cc.getName()+" "+cc.getAmount()+" "+cc.getCardNumber()+" "+cc.getCardType()+"  "+cc.getCvv();
		return cService.createProfileService(cc);
	}
	
	@PutMapping("/{cno}/{c}")  //edit resource
	public String editProfile(@PathVariable("cno") String cNumber,@PathVariable("c") String cvv,@RequestBody Card cc) {
		//return "profile edited for credit card no "+cNumber+" and cvv is "+cvv+" "+cc.getAmount()+" "+cc.getName()+" "+cc.getCardType();
		return cService.editProfileService(cNumber,cvv,cc);
	}
	@DeleteMapping("/{cno}")  //delete resource
	public String deleteProfile(@PathVariable("cno") String cNumber) {
		//return "profile deleted";
		return cService.deleteProfileService(cNumber);
	}
	@GetMapping("/{cno}") //view resource
	public Card viewProfile(@PathVariable("cno") String cNumber) {
		//return "profile viewed";
		return cService.viewProfileService(cNumber);
	}
	@GetMapping
	public List<Card> viewAll(){
		return cService.viewAllService();
	}
	@PatchMapping //partially edit the resource
	public String oartiallyEditProfile() {
		return "profile edited partially";
	}
}
