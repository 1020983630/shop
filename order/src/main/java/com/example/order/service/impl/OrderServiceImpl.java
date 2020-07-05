package com.example.order.service.impl;

import com.example.order.pojo.Order;
import com.example.order.repository.OrderRepository;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Optional<Order> getById(String id) {
        return orderRepository.findById(id);
    }
}
