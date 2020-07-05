package com.example.order.service;

import com.example.order.pojo.OrderForm;

import java.util.Optional;

public interface OrderFormService {
    Optional<OrderForm> getById(String id);
}
