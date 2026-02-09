package com.synechronepuneproducer.controller;

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

import com.synechronepuneproducer.entity.Product;
import com.synechronepuneproducer.service.UpiServiceInterface;
@RestController
@RequestMapping("api/v1")
public class UpiController {
	
	@Autowired //means dependency injection so here spring will create object of UpiService and store inside UpiServiceInterface automatically
	private UpiServiceInterface uService;
	
	@PostMapping  //create transaction or product
	public String createTransaction(@RequestBody Product pd) {
		return uService.createTransactionService(pd);
	}
	@PutMapping("/{tid}")  //edit transaction or product based on pathvariable tid which contains cvv
	public String editTransaction(@PathVariable("tid") int mycvv,@RequestBody Product pd) {
		pd.setCvv(mycvv);
		return uService.editTransactionService(pd);
	}
	@PatchMapping("/{tid}")  //edit transaction or product based on pathvariable tid which contains cvv
	public String editTransaction1(@PathVariable("tid") int mycvv,@RequestBody Product pd) {
		
		
		pd.setCvv(mycvv);
		return uService.editTransactionService(pd);
	}
	@DeleteMapping("/{tid}")  //delete transaction or product
	public String deleteTransaction(@PathVariable("tid") int mycvv) {
		return uService.deleteTransactionService(mycvv);
	}
	@GetMapping  //view transaction or product
	public List<Product> viewTransaction() {
		return uService.viewTransactionService();
	}
	
	
	@GetMapping("/{tid}")
	public Product getParticularTransaction(@PathVariable("tid") int mycvv) {
		return uService.getRecord(mycvv);
	}
	
	
	

}















