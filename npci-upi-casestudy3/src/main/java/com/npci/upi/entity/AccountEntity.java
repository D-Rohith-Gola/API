package com.npci.upi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AccountEntity {

    @Id
    private String userId;

    private double balance;

    public AccountEntity() {}

    public AccountEntity(String userId, double balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
