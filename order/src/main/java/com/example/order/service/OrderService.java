package com.example.order.service;

import com.example.order.pojo.Order;

import java.util.Optional;

public interface OrderService {
    Optional<Order> getById(String id);
}
