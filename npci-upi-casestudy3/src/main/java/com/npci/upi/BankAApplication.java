package com.npci.upi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BankAApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(NpciUpiApplication.class)
                .properties(
                        "server.port=9001",
                        "spring.profiles.active=bankA",
                        "bank.instance=bank-A"
                )
                .run(args);
    }
}