package com.rohith.payment_service.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final RestTemplate restTemplate;

    private static final String ORDER_SERVICE_URL =
            "http://order-service/api/orders";

    public PaymentServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @Retry(name = "orderService", fallbackMethod = "getOrderFallback")
    @CircuitBreaker(name = "orderService", fallbackMethod = "getOrderFallback")
    public Map<String, Object> getOrderById(String orderId) {
        return restTemplate.getForObject(
                ORDER_SERVICE_URL + "/" + orderId,
                Map.class
        );
    }

    @Override
    public List<Map<String, Object>> getAllOrders() {
        return restTemplate.getForObject(
                ORDER_SERVICE_URL,
                List.class
        );
    }

    // fallback
    public Map<String, Object> getOrderFallback(String orderId, Throwable ex) {

        Map<String, Object> fallback = new HashMap<>();
        fallback.put("id", orderId);
        fallback.put("item", "fallback-item");
        fallback.put("price", 0);
        fallback.put("instance", "fallback-response");

        return fallback;
    }
}

