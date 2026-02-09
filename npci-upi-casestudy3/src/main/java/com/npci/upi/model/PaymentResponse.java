package com.npci.upi.model;

import java.time.LocalDateTime;

public class PaymentResponse {

    private String status;
    private String message;
    private Long transactionId;

    private String payer;
    private String payerBank;

    private String payee;
    private String payeeBank;

    private double amount;
    private LocalDateTime timestamp;

    private boolean fallback;

    public PaymentResponse() {}

    public PaymentResponse(
            String status,
            String message,
            Long transactionId,
            String payer,
            String payerBank,
            String payee,
            String payeeBank,
            double amount,
            LocalDateTime timestamp,
            boolean fallback
    ) {
        this.status = status;
        this.message = message;
        this.transactionId = transactionId;
        this.payer = payer;
        this.payerBank = payerBank;
        this.payee = payee;
        this.payeeBank = payeeBank;
        this.amount = amount;
        this.timestamp = timestamp;
        this.fallback = fallback;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public String getPayerBank() {
		return payerBank;
	}

	public void setPayerBank(String payerBank) {
		this.payerBank = payerBank;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getPayeeBank() {
		return payeeBank;
	}

	public void setPayeeBank(String payeeBank) {
		this.payeeBank = payeeBank;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isFallback() {
		return fallback;
	}

	public void setFallback(boolean fallback) {
		this.fallback = fallback;
	}
}