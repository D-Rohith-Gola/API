package com.synechronepuneproducer.service;

import java.util.List;

import com.synechronepuneproducer.entity.Product;

public interface UpiServiceInterface {
	public String createTransactionService(Product pd);
	public String editTransactionService(Product pd);
	public String deleteTransactionService(int mycvv);
	public List<Product> viewTransactionService();
	public Product getRecord(int mycvv);
}
