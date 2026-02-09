package com.cardconsumer.controller;

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

import com.cardconsumer.dto.CreditCard;

@RestController
@RequestMapping("api/v1/cardconsumer")
public class CardConsumerController {

	@GetMapping
	public  List<CreditCard> viewAll(){
		RestTemplate rt =new RestTemplate();
		List<CreditCard> ll =rt.getForObject("http://localhost:8080/api/v1/card", List.class);
		return ll;
	}
	
	@PostMapping
	public String createPost(@RequestBody CreditCard ee) {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject("http://localhost:8080/api/v1/card", ee, String.class);
		return response;
	}

	@PutMapping("/{id}")
	public String updatePost(@RequestBody CreditCard ee, @PathVariable String id) {
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://localhost:8080/api/v1/card" + id, ee);
		return "record updated";
	}

	@DeleteMapping("/{id}")
	public String deletePost(@PathVariable String id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8080/api/v1/card" + id);
		return "record deleted";
	}
}








