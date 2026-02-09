
package com.npci.upi.model;

public class BankResponse {
    private String status;
    private String instance;
    private String message;

    public BankResponse(String status, String instance, String message) {
        this.status = status;
        this.instance = instance;
        this.message = message;
    }

    public String getStatus() { return status; }
    public String getInstance() { return instance; }
    public String getMessage() { return message; }
}