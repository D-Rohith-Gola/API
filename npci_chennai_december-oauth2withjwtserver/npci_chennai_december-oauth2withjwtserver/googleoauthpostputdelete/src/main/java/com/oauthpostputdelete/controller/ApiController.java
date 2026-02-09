package com.oauthpostputdelete.controller;



import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/data")
    public String get() {
        return "GET OK for ";
    }

    @PostMapping("/data")
    public String post() {
        return "POST OK";
    }

    @PutMapping("/data")
    public String put() {
        return "PUT OK";
    }

    @DeleteMapping("/data")
    public String delete() {
        return "DELETE OK";
    }
}

