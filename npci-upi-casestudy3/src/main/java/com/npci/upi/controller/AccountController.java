package com.npci.upi.controller;

import org.springframework.web.bind.annotation.*;

import com.npci.upi.entity.AccountEntity;
import com.npci.upi.repository.AccountRepository;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountRepository repository;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public AccountEntity create(@RequestBody AccountEntity account) {
        return repository.save(account);
    }

    @GetMapping("/{userId}")
    public AccountEntity get(@PathVariable String userId) {
        return repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}