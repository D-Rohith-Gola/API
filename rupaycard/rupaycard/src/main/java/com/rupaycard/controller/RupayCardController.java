package com.rupaycard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rupaycard.entity.Card;
import com.rupaycard.service.RupayCardServiceInterface;

@RestController
@RequestMapping("api/v1/rupaycard")
public class RupayCardController {
	
	@Autowired
	private RupayCardServiceInterface rService;

	@PostMapping
	public Card createCard(@RequestBody Card cc) {
		return rService.createCardService(cc);
	}
	
	@PutMapping("/{cn}/{ct}/{cun}")
	public String editCardService(@PathVariable("cn") String cardName , @PathVariable("ct") String cardType, @PathVariable("cun") String cardUserName, @RequestBody Card cc) {
		return rService.editCardService(cardName, cardType, cardUserName, cc);
	}
	
	@DeleteMapping("/{cn}")
	public long deleteCardService(@PathVariable("cn") long cardNo) {
		return rService.deleteCardService(cardNo);
	}
	
	@GetMapping("/{cn}")
	public Card viewCardDetails(@PathVariable("cn") long cn) {
		return rService.viewCardDetails(cn);
	}
	
	@GetMapping
	public List<Card> viewAll(){
		return rService.viewAllCardDetails();
	}
}
