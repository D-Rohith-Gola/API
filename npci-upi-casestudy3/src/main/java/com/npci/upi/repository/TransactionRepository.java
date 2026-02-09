package com.npci.upi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.upi.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
