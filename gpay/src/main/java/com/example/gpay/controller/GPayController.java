package com.example.gpay.controller;

import com.example.gpay.entity.Account;
import com.example.gpay.service.GpayServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/gpay/account")
public class GPayController {

    @Autowired
    GpayServiceInterface gpayService;

    @PostMapping
    public String registerAccount(@RequestBody Account account){
        return gpayService.createAccountService(account);
    }

    @PutMapping("/{vpa}")
    public String updateAccount(@PathVariable("vpa") String vpa,@RequestBody Account account){
        return gpayService.updateAccountService(vpa,account);
    }

    @GetMapping("/{vpa}")
    public Account viewAccount(@PathVariable("vpa") String vpa){
        return gpayService.fetchAccountService(vpa);
    }

    @DeleteMapping("/{vpa}")
    public String deleteAccount(@PathVariable("vpa") String vpa){
        return gpayService.removeAccountService(vpa);
    }
}
