package com.npci.upi.npci.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;


import com.npci.upi.account.AccountService;
import com.npci.upi.bank.BankFactory;
import com.npci.upi.bank.BankService;
import com.npci.upi.entity.Transaction;
import com.npci.upi.entity.UserProfile;
import com.npci.upi.exception.InsufficientBalanceException;
import com.npci.upi.model.PaymentRequest;
import com.npci.upi.model.PaymentResponse;
import com.npci.upi.npci.NpciSwitchService;
import com.npci.upi.repository.TransactionRepository;
import com.npci.upi.user.UserProfileService;

@Service
public class NpciSwitchServiceImpl implements NpciSwitchService {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private BankFactory bankFactory;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    @Transactional
    @CircuitBreaker(name = "bankCB", fallbackMethod = "npcFallback")
    @Retry(name = "bankRetry")
    public PaymentResponse process(PaymentRequest request) {

        UserProfile payerProfile = userProfileService.getUser(request.getPayer());
        UserProfile payeeProfile = userProfileService.getUser(request.getPayee());

        BankService payerBank =
                bankFactory.getBank(payerProfile.getIssuerBank());

        try {
            payerBank.debit(request.getPayer(), request.getAmount());

            accountService.debit(request.getPayer(), request.getAmount());
            accountService.credit(request.getPayee(), request.getAmount());

            Transaction txn = transactionRepository.save(
                    new Transaction(
                            request.getPayer(),
                            request.getPayee(),
                            request.getAmount(),
                            "SUCCESS"
                    )
            );

            return new PaymentResponse(
                    "SUCCESS",
                    "Transaction completed successfully",
                    txn.getId(),
                    request.getPayer(),
                    payerProfile.getIssuerBank(),
                    request.getPayee(),
                    payeeProfile.getIssuerBank(),
                    request.getAmount(),
                    txn.getTimestamp(),
                    false
            );

        }
        catch (InsufficientBalanceException ex) {

            Transaction txn = transactionRepository.save(
                    new Transaction(
                            request.getPayer(),
                            request.getPayee(),
                            request.getAmount(),
                            "FAILED"
                    )
            );

            return new PaymentResponse(
                    "FAILED",
                    ex.getMessage(),
                    txn.getId(),
                    request.getPayer(),
                    payerProfile.getIssuerBank(),
                    request.getPayee(),
                    payeeProfile.getIssuerBank(),
                    request.getAmount(),
                    txn.getTimestamp(),
                    false
            );
        }
    }

    public PaymentResponse npcFallback(
            PaymentRequest request,
            Throwable ex
    ) {

        Transaction txn = transactionRepository.save(
                new Transaction(
                        request.getPayer(),
                        request.getPayee(),
                        request.getAmount(),
                        "PENDING"
                )
        );

        return new PaymentResponse(
                "PENDING",
                "NPCI retry scheduled due to bank unavailability",
                txn.getId(),
                request.getPayer(),
                null,
                request.getPayee(),
                null,
                request.getAmount(),
                txn.getTimestamp(),
                true
        );
    }
}