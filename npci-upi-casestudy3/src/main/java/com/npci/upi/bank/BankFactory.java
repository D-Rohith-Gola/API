package com.npci.upi.bank;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class BankFactory {

    private final Map<String, BankService> banks;

    public BankFactory(Map<String, BankService> banks) {
        this.banks = banks;
    }

    public BankService getBank(String bankName) {
        BankService bank = banks.get(bankName);
        if (bank == null) {
            throw new RuntimeException("No bank service found for: " + bankName);
        }
        return bank;
    }
}