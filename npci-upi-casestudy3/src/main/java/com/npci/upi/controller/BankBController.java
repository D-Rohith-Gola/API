package com.npci.upi.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import com.npci.upi.model.BankResponse;
import com.npci.upi.model.PaymentRequest;
import com.npci.upi.model.PaymentResponse;
import com.npci.upi.npci.NpciSwitchService;

@RestController
@RequestMapping("/api/bankB")
@Profile("bankB")
public class BankBController {

    private final NpciSwitchService npciSwitchService;

    public BankBController(NpciSwitchService npciSwitchService) {
        this.npciSwitchService = npciSwitchService;
    }

    @PostMapping("/pay")
    public PaymentResponse pay(@RequestBody PaymentRequest request) {
        return npciSwitchService.process(request);
    }
}
