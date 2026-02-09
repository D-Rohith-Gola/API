package com.npci.upi.account;

public interface AccountService {

    void debit(String userId, double amount);

    void credit(String userId, double amount);
}
