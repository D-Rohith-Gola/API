package com.rohith.order_service.service;

import java.util.List;
import java.util.Map;

import com.rohith.order_service.entity.Order;

public interface OrderService {
    Order getOrderById(String id);
    List<Order> getAllOrders();
    Order createOrder(Order order);
    Order updateOrder(String id, Order order);
    void deleteOrder(String id);
}
