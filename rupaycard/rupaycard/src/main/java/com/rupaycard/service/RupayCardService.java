package com.rupaycard.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rupaycard.dao.RupayCardDAOInterface;
import com.rupaycard.entity.Card;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
@Transactional
public class RupayCardService implements RupayCardServiceInterface{
	
	@Autowired
	private RupayCardDAOInterface  rDao;

	@Override
	public Card createCardService(Card cc) {
		rDao.save(cc);
		return cc;
	}
	
	@Override
	public String editCardService(String cardName, String cardType, String cardUserName, Card cc) {
		rDao.saveAndFlush(cc);
		return "Profile Edited Successfully"+cc;
	}
	
	@Override
	public long deleteCardService(long cardNo) {
		rDao.deleteById(cardNo);
		return cardNo;
	}
	
	@Override
	public Card viewCardDetails(long cardNo) {
		Optional<Card> cc = rDao.findById(cardNo);
		return cc.get();
	}

	@Override
	@Retry(name = "rupaycard", fallbackMethod = "fallback")
	@CircuitBreaker(name = "rupaycard", fallbackMethod = "fallback")
	public List<Card> viewAllCardDetails(){
		List<Card> ll = rDao.findAll();
		
		if(ll.size()>2) {
			throw new RuntimeException();
		}
		return ll;
	}
	
	public List<Card> fallback(Throwable ex) {
		Card c1 = new Card();
		c1.setCardName("Dummy Card");
		c1.setCardType("Dummy Card Type");
		c1.setCardUserName("Dummy User");
		c1.setCardCvv(000);
		c1.setCardNo(000000000);

		List<Card> ll =new ArrayList<Card>();
		ll.add(c1);
		return ll;
	}
}







