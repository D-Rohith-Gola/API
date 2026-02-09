package com.example.gpay.service;

import com.example.gpay.dto.TransactionRequest;
import com.example.gpay.entity.Account;
import com.example.gpay.exception.AccountDoesNotExistException;
import com.example.gpay.exception.InsufficientBalanceException;
import com.example.gpay.repository.GPayRepositoryInterface;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionService implements TransactionServiceInterface {
	@Autowired
	private BankProcessingService bankService;

    @Autowired
    GPayRepositoryInterface gpayRepo;

    @Retry(name = "bankService", fallbackMethod = "txnFallback")
    @CircuitBreaker(name = "bankService", fallbackMethod = "txnFallback")
    @Override
    public String performTxnService(TransactionRequest transactionRequest) {
        Account payeeAccount = gpayRepo.findById(transactionRequest.getPayeeVpa()).orElseThrow(()->new AccountDoesNotExistException("Payee VPA "+transactionRequest.getPayeeVpa()+" in not valid. Please provide correct VPA"));
        Account payerAccount = gpayRepo.findById(transactionRequest.getPayerVpa()).orElseThrow(()->new AccountDoesNotExistException("Payer VPA "+transactionRequest.getPayerVpa()+" in not valid. Please provide correct VPA"));

        if(payerAccount.getAmount()<transactionRequest.getAmount()){
            throw new InsufficientBalanceException("Payer does not have sufficient balance to perform the transaction");
        }
        
        try {
            bankService.debit(transactionRequest.getAmount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        payerAccount.setAmount(payerAccount.getAmount()-transactionRequest.getAmount());
        payeeAccount.setAmount(payeeAccount.getAmount()+ transactionRequest.getAmount());

        gpayRepo.save(payeeAccount);
        gpayRepo.save(payerAccount);

        return "Transaction successfully completed";
    } 
    
    public String txnFallback(TransactionRequest request, Throwable ex) {
        return "Transaction is PENDING. Bank service is temporarily unavailable. Amount will be processed shortly.";
    }

}
