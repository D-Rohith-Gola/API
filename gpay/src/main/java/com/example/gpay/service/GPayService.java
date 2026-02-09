package com.example.gpay.service;

import com.example.gpay.entity.Account;
import com.example.gpay.exception.AccountDoesNotExistException;
import com.example.gpay.exception.DuplicateMobileNumberException;
import com.example.gpay.repository.GPayRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GPayService implements GpayServiceInterface {

    @Autowired
    GPayRepositoryInterface gpayRepo;

    @Override
    public String createAccountService(Account account) {
        if (gpayRepo.existsByMobileNumber(account.getMobileNumber())) {
            throw new DuplicateMobileNumberException("Mobile number already registered: " + account.getMobileNumber());
        }
        gpayRepo.save(account);
        return "User registered successfully and the unique vpa generated is " + account.getVpa();
    }

    @Override
    public String updateAccountService(String vpa, Account account) {
        boolean isUserPresent = gpayRepo.findById(vpa).isPresent();
        if (isUserPresent) {
            gpayRepo.saveAndFlush(account);
            return "User details updated successfully";
        }
        return "User with the provided VPA does not exist";
    }

    @Override
    public Account fetchAccountService(String vpa) {
        boolean isUserPresent = gpayRepo.findById(vpa).isPresent();
        if (isUserPresent) {
            return gpayRepo.findById(vpa).get();
        }
        throw new AccountDoesNotExistException("Account with the vpa "+vpa+" does not exist in DB");
    }

    @Override
    public String removeAccountService(String vpa) {
        boolean isUserPresent = gpayRepo.findById(vpa).isPresent();
        if (isUserPresent) {
            gpayRepo.deleteById(vpa);
            return "User deleted successfully";
        }
        return "User with the provided VPA does not exist";
    }
}
