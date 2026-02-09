package com.npci.upi.bank.impl;

import org.springframework.stereotype.Service;

import com.npci.upi.bank.BankService;
import com.npci.upi.exception.InsufficientBalanceException;
import com.npci.upi.model.BankResponse;
import com.npci.upi.repository.AccountRepository;

@Service("SBI")
public class SbiBankServiceImpl implements BankService {

    private final AccountRepository repository;

    public SbiBankServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public BankResponse debit(String userId, double amount) {

        var acc = repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (acc.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        acc.setBalance(acc.getBalance() - amount);
        repository.save(acc);

        return new BankResponse("SUCCESS", "Debited", "SBI");
    }


    @Override
    public BankResponse credit(String userId, double amount) {
        var acc = repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        acc.setBalance(acc.getBalance() + amount);
        repository.save(acc);

        return new BankResponse("SUCCESS", "Credited", "SBI");
    }
}