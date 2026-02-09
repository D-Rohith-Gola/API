package com.npci.upi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BankBApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(NpciUpiApplication.class)
                .properties(
                        "server.port=9002",
                        "spring.profiles.active=bankB",
                        "bank.instance=bank-B"
                )
                .run(args);
    }
}