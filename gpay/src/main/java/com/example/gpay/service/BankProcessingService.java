package com.example.gpay.service;

import com.example.gpay.dto.BankResponse;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BankProcessingService {

    private Random random = new Random();
    private AtomicInteger counter = new AtomicInteger(0);

    public BankResponse debit(int amount) throws InterruptedException {

        // Simulated load balancing
        String instance = (counter.incrementAndGet() % 2 == 0)
                ? "BANK-A"
                : "BANK-B";

        int chance = random.nextInt(10);

        // 30% failure
        if (chance < 3) {
            throw new RuntimeException("Bank timeout");
        }

        // delay simulation
        if (chance < 5) {
            Thread.sleep(2000);
        }

        return new BankResponse(
                "SUCCESS",
                "ICICI" + random.nextInt(999999),
                instance
        );
    }
}
