package com.upiafternoon.controller;

import java.util.List;

import com.upiafternoon.entity.Account;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountsListResponse {

	@XmlElement(name = "account")
	private List<Account> accounts;

	public AccountsListResponse(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public AccountsListResponse() {
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
