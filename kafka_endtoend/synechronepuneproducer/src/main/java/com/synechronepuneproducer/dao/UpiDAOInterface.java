package com.synechronepuneproducer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synechronepuneproducer.entity.Product;

@Repository
public interface UpiDAOInterface extends JpaRepository<Product, Integer>{

}
