package com.creditcard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditcard.entity.Card;

@Repository
public interface CreditCardDAOInterface extends JpaRepository<Card, String> {
}
