package com.synechronepuneproducer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synechronepuneproducer.dao.UpiDAOInterface;
import com.synechronepuneproducer.entity.Product;

@Service
@Transactional //spring will handle all the transaction( commit, rollback) automatically for insert, delete and update
public class UpiService implements UpiServiceInterface {
	
	@Autowired
	private UpiDAOInterface uDao;

	@Override
	public String createTransactionService(Product pd) {
		uDao.save(pd); //jpa will run insert query internelly i.e. insert into product values(?,?,?,?)
		return "transaction created by service";
	}

	@Override
	public String editTransactionService(Product pd) {
		uDao.saveAndFlush(pd);
		return "transaction edited by service";
	}

	@Override
	public String deleteTransactionService(int mycvv) {
		uDao.deleteById(mycvv);
		return "transaction deleted by service";
	}

	@Override
	public List<Product> viewTransactionService() {
		// TODO Auto-generated method stub
		return uDao.findAll(); //select * from product
	}

	@Override
	public Product getRecord(int mycvv) {
		Optional<Product> pp = uDao.findById(mycvv);
		return pp.get();
	}

}











