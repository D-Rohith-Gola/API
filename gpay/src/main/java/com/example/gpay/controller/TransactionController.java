package com.example.gpay.controller;

import com.example.gpay.dto.TransactionRequest;
import com.example.gpay.service.TransactionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/gpay/transactions")
public class TransactionController {
    @Autowired
    TransactionServiceInterface txnService;

    @PostMapping
    public String performTransaction(@RequestBody TransactionRequest transactionRequest){
        return txnService.performTxnService(transactionRequest);
    }
}
