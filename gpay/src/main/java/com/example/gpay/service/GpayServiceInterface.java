package com.example.gpay.service;

import com.example.gpay.entity.Account;

public interface GpayServiceInterface {

    String createAccountService(Account account);

    String updateAccountService(String vpa, Account account);

    Account fetchAccountService(String vpa);

    String removeAccountService(String vpa);
}
