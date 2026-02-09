package com.rohith.payment_service.service;

import java.util.List;
import java.util.Map;

public interface PaymentService {

    Map<String, Object> getOrderById(String orderId);

    List<Map<String, Object>> getAllOrders();
}