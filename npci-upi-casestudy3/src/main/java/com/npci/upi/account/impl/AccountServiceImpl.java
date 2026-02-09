package com.npci.upi.account.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.upi.account.AccountService;
import com.npci.upi.entity.AccountEntity;
import com.npci.upi.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    public void debit(String userId, double amount) {
        AccountEntity acc = repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        acc.setBalance(acc.getBalance() - amount);
        repository.save(acc);
    }

    @Override
    public void credit(String userId, double amount) {
        AccountEntity acc = repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        acc.setBalance(acc.getBalance() + amount);
        repository.save(acc);
    }
}