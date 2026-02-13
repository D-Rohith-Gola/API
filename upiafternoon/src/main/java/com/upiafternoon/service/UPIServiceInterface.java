package com.upiafternoon.service;

import java.util.List;

import com.upiafternoon.entity.Account;

public interface UPIServiceInterface {

	String createAccountService(Account ac);

	String viewAccountService(String email);

	String editAccountService(String email, Account ac);

	String deleteAccountService(String email);
	
	List<Account> getAllAccount();

}
