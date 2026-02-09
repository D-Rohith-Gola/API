package com.npci.upi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class NpciUpiApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(NpciUpiApplication.class)
                .properties(
                        "server.port=8085",
                        "spring.profiles.active=npci",
                        "bank.instance=npci-upi"
                )
                .run(args);
    }
}