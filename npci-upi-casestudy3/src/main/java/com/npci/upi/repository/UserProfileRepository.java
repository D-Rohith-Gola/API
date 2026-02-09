package com.npci.upi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.npci.upi.entity.UserProfile;

public interface UserProfileRepository
        extends JpaRepository<UserProfile, String> {
}