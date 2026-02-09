package com.npci.upi.controller;

import org.springframework.web.bind.annotation.*;

import com.npci.upi.entity.UserProfile;
import com.npci.upi.repository.UserProfileRepository;

@RestController
@RequestMapping("/api/user")
public class UserProfileController {

    private final UserProfileRepository repository;

    public UserProfileController(UserProfileRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/create")
    public UserProfile create(@RequestBody UserProfile profile) {
        return repository.save(profile);
    }

    @GetMapping("/{id}")
    public UserProfile get(@PathVariable String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
