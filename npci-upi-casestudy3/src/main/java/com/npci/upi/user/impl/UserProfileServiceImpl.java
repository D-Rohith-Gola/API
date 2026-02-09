package com.npci.upi.user.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.npci.upi.entity.UserProfile;
import com.npci.upi.user.UserProfileService;

import jakarta.annotation.PostConstruct;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final Map<String, UserProfile> users = new HashMap<>();

    @PostConstruct
    public void init() {
        users.put("USER1", new UserProfile("USER1", "user1@upi", "HDFC"));
        users.put("USER2", new UserProfile("USER2", "user2@upi", "SBI"));
    }

    @Override
    public UserProfile getUser(String userId) {
        UserProfile profile = users.get(userId);
        if (profile == null) {
            throw new RuntimeException("User not found: " + userId);
        }
        return profile;
    }
}