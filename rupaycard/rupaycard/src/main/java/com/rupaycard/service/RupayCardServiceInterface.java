package com.rupaycard.service;

import java.util.List;

import com.rupaycard.entity.Card;

public interface RupayCardServiceInterface {

	Card createCardService(Card cc);
	
	String editCardService(String cardName, String cardType, String cardUserName, Card cc);

	long deleteCardService(long cardNo);

	Card viewCardDetails(long cardNo);

	List<Card> viewAllCardDetails();
}
