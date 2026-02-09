package com.upiafternoon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upiafternoon.dao.UPIDAOInterface;
import com.upiafternoon.entity.Account;

@Service
@Transactional
public class UPIService implements UPIServiceInterface {
	
	@Autowired
	private UPIDAOInterface uDao;

	@Override
	public String createAccountService(Account ac) {
		uDao.save(ac);
		return "account opened successfully";
	}

	@Override
	public String viewAccountService(String email) {
		uDao.findById(email);
		return "account viewed successfully";
	}

	@Override
	public String editAccountService(String email, Account ac) {
		if(uDao.findById(email).isPresent()) {
			uDao.save(ac);
		}
		return "account edited successfully";
	}

	@Override
	public String deleteAccountService(String email) {
		uDao.deleteById(email);
		return "account deleted successfully";
	}

}
