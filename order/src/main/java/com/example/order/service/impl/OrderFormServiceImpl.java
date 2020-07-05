package com.example.order.service.impl;

import com.example.order.pojo.OrderForm;
import com.example.order.repository.OrderFormRepository;
import com.example.order.service.OrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderFormServiceImpl implements OrderFormService {
    @Autowired
    private OrderFormRepository orderFormRepository;

    @Override
    public Optional<OrderForm> getById(String id) {
        return orderFormRepository.findById(id);
    }
}
