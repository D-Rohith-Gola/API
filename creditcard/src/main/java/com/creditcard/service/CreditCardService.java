package com.creditcard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.dao.CreditCardDAOInterface;
import com.creditcard.entity.Card;

@Service
public class CreditCardService implements CreditCardServiceInterface {
	
	@Autowired
	private CreditCardDAOInterface ccDao;

	@Override
	public String createProfileService(Card cc) {
		ccDao.save(cc);
		return "profile created in service layer "+cc.getName()+" "+cc.getAmount()+" "+cc.getCardNumber()+" "+cc.getCardType()+"  "+cc.getCvv();
		
	}

	@Override
	public String editProfileService(String cNumber, String cvv, Card cc) {
		ccDao.saveAndFlush(cc);
		return "profile edited";
	}

	@Override
	public String deleteProfileService(String cNumber) {
		ccDao.deleteById(cNumber);
		return "profile deleted";
	}

	@Override
	public Card viewProfileService(String cNumber) {
		Optional<Card> cc = ccDao.findById(cNumber);
		return cc.get();
	}

	@Override
	public List<Card> viewAllService() {
		// TODO Auto-generated method stub
		return ccDao.findAll();
	}

}
