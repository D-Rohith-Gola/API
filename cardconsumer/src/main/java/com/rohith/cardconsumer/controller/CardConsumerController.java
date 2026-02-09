package com.rohith.cardconsumer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rohith.cardconsumer.controller.dto.CreditCard;

@RestController
@RequestMapping("api/v1/cardconsumer")
public class CardConsumerController {

	@GetMapping
	public List<CreditCard> viewAll(){
		RestTemplate rt = new RestTemplate();
		List<CreditCard> ll = rt.getForObject("http://localhost:8080/api/v1/creditcard", List.class);
		return ll;
	}
	
	@PostMapping
	public String createPost(@RequestBody CreditCard c) {
		RestTemplate rt = new RestTemplate();
		String response = rt.postForObject("http://localhost:8080/api/v1/creditcard",c,String.class);
		return response;
	}
	
	@PutMapping("/{id}")
	public String updatePost(@RequestBody CreditCard c, @PathVariable("id") String id) {
		RestTemplate rt = new RestTemplate();
		rt.put("http://localhost:8080/api/v1/creditcard"+"/" +id, c);
		return "record updated";
	}
	
	@DeleteMapping("/{id}")
	public String deletePost(@PathVariable String id) {
		RestTemplate rt = new RestTemplate();
		rt.delete("http://localhost:8080/api/v1/creditcard"+"/" +id);
		return "record deleted";
	}
}
