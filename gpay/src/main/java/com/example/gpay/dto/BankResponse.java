package com.example.gpay.dto;

public class BankResponse {
    private String status;
    private String bankRef;
    private String instance;

    public BankResponse(String status, String bankRef, String instance) {
        this.status = status;
        this.bankRef = bankRef;
        this.instance = instance;
    }

    public String getStatus() {
        return status;
    }

    public String getBankRef() {
        return bankRef;
    }

    public String getInstance() {
        return instance;
    }
}
