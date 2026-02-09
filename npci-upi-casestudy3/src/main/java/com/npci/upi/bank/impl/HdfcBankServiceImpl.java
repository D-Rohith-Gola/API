package com.npci.upi.bank.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.npci.upi.bank.BankService;
import com.npci.upi.exception.InsufficientBalanceException;
import com.npci.upi.model.BankResponse;
import com.npci.upi.repository.AccountRepository;

@Service("HDFC")
public class HdfcBankServiceImpl implements BankService {

    private final AccountRepository repository;
    private final Random random = new Random();

    public HdfcBankServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public BankResponse debit(String userId, double amount) {

        if (random.nextInt(2) == 0) { 
            throw new RuntimeException("HDFC bank service temporarily unavailable");
        }

        var acc = repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (acc.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        acc.setBalance(acc.getBalance() - amount);
        repository.save(acc);

        return new BankResponse("SUCCESS", "Debited", "HDFC");
    }

    @Override
    public BankResponse credit(String userId, double amount) {

        if (random.nextInt(6) == 0) {
            throw new RuntimeException("HDFC credit service timeout");
        }

        var acc = repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        acc.setBalance(acc.getBalance() + amount);
        repository.save(acc);

        return new BankResponse("SUCCESS", "Credited", "HDFC");
    }
}
