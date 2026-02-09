package com.example.gpay.service;

import com.example.gpay.dto.TransactionRequest;

public interface TransactionServiceInterface {
    String performTxnService(TransactionRequest transactionRequest);
}
