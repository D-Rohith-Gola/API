package com.npci.upi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserProfile {

    @Id
    private String userId;

    private String upiId;
    private String issuerBank;

    public UserProfile() {}

    public UserProfile(String userId, String upiId, String issuerBank) {
        this.userId = userId;
        this.upiId = upiId;
        this.issuerBank = issuerBank;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public String getIssuerBank() {
		return issuerBank;
	}

	public void setIssuerBank(String issuerBank) {
		this.issuerBank = issuerBank;
	}
}
