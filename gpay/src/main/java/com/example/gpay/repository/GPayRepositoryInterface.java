package com.example.gpay.repository;

import com.example.gpay.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GPayRepositoryInterface extends JpaRepository<Account,String> {
    boolean existsByMobileNumber(String mobileNumber);
}
