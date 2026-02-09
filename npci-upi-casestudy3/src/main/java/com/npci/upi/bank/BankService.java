package com.npci.upi.bank;

import com.npci.upi.model.BankResponse;

public interface BankService {

    BankResponse debit(String userId, double amount);

    BankResponse credit(String userId, double amount);
}
