package com.upiafternoon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upiafternoon.entity.Account;

@Repository
public interface UPIDAOInterface extends JpaRepository<Account, String>{

}
