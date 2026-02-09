package com.cbdcconsumer.controller;

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
import org.springframework.web.client.RestTemplate;

import com.cbdcconsumer.dto.Card;

@RestController
@RequestMapping("api/v1/cbdcconsumer")
public class cbdcController {

//	@Autowired
//	DiscoveryClient ds;
	
	@Autowired
	RestTemplate rTemp;
	
	@GetMapping
		public List<Card> viewAll(){
//		List<ServiceInstance> ss = ds.getInstances("RUPAYCARD");
//		ServiceInstance s1 = ss.get(0);
//		String url = s1.getUri().toString();
//		RestTemplate rTemp = new RestTemplate();
		List<Card> tt = rTemp.getForObject("https://RUPAYCARD/api/v1/rupaycard", List.class);
		
		return tt;
}
	@PostMapping
	public Card createCard(@RequestBody Card c) {
//		List<ServiceInstance> ss = ds.getInstances("RUPAYCARD");
//		ServiceInstance s1 = ss.get(0);
//		String url = s1.getUri().toString();
//		RestTemplate rTemp = new RestTemplate();
		Card responds = rTemp.postForObject("https://RUPAYCARD/api/v1/rupaycard", c, Card.class);
		return responds;
	}
	
	@PutMapping("/{id}")
	public String updateCard(@RequestBody Card c, @PathVariable("id") String id) {
//		List<ServiceInstance> ss = ds.getInstances("RUPAYCARD");
//		ServiceInstance s1 = ss.get(0);
//		String url = s1.getUri().toString();
//		RestTemplate rTemp = new RestTemplate();
		rTemp.put("https://RUPAYCARD/api/v1/rupaycard"+"/"+id, c);
		return "Card Updated Successfully";
	}
	
	@DeleteMapping("/{id}")
	public String deleteCard(@PathVariable("id") String id) {
//		List<ServiceInstance> ss = ds.getInstances("RUPAYCARD");
//		ServiceInstance s1 = ss.get(0);
//		String url = s1.getUri().toString();
//		RestTemplate rTemp = new RestTemplate();
		rTemp.delete("https://RUPAYCARD/api/v1/rupaycard"+"/"+id);
		return "Card deleted successfully";		
	}
	
}
