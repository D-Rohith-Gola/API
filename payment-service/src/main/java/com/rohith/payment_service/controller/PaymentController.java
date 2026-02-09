package com.rohith.payment_service.controller;

import org.springframework.web.bind.annotation.*;
import com.rohith.payment_service.service.PaymentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/order/{id}")
    public Map<String, Object> getPayment(@PathVariable String id) {
        return paymentService.getOrderById(id);
    }

    @GetMapping("/orders")
    public List<Map<String, Object>> getAllOrders() {
        return paymentService.getAllOrders();
    }
}
