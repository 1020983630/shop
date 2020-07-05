package com.example.order.service.impl;

import com.example.order.pojo.OrderForm;
import com.example.order.repository.OrderFormRepository;
import com.example.order.service.OrderFormService;
import com.example.order.vo.OrderFormVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderFormServiceImpl implements OrderFormService {
    @Autowired
    private OrderFormRepository orderFormRepository;

    @Override
    public OrderFormVO getById(String id) {
        OrderFormVO orderFormVO = new OrderFormVO();
        Optional<OrderForm> orderForm = orderFormRepository.findById(id);

        BeanUtils.copyProperties(orderForm.get(), orderFormVO);

        return orderFormVO;
    }
}
