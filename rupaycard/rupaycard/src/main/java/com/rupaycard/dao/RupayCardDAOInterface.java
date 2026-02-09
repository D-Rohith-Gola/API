package com.rupaycard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rupaycard.entity.Card;

@Repository
public interface RupayCardDAOInterface extends JpaRepository<Card, Long>{

}
