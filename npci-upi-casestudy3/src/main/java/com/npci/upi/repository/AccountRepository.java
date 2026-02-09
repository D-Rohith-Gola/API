package com.npci.upi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.upi.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, String> {
}