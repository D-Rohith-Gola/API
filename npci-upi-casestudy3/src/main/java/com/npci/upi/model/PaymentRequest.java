
package com.npci.upi.model;

public class PaymentRequest {
    private String payer;
    private String payee;
    private double amount;

    public String getPayer() { return payer; }
    public void setPayer(String payer) { this.payer = payer; }
    public String getPayee() { return payee; }
    public void setPayee(String payee) { this.payee = payee; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
