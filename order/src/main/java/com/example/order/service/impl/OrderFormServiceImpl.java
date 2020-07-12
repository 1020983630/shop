package com.example.order.service.impl;

import com.example.common.dto.ResultT;
import com.example.common.enums.EOperation;
import com.example.order.feign.StockClient;
import com.example.order.pojo.OrderForm;
import com.example.order.repository.OrderFormRepository;
import com.example.order.request.PlaceOrderRequest;
import com.example.order.service.OrderFormService;
import com.example.order.vo.OrderFormVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderFormServiceImpl implements OrderFormService {
    @Autowired
    private OrderFormRepository orderFormRepository;

    @Autowired
    private StockClient stockClient;

    @Override
    public OrderFormVO getById(String id) {
        OrderFormVO orderFormVO = new OrderFormVO();
        Optional<OrderForm> orderForm = orderFormRepository.findById(id);

        BeanUtils.copyProperties(orderForm.get(), orderFormVO);

        return orderFormVO;
    }

    @Override
    public EOperation placeOrder(PlaceOrderRequest request) {
        OrderForm orderForm = new OrderForm();
        orderForm.setId(UUID.randomUUID().toString().replace("-", ""));
        orderForm.setCreateTime(LocalDateTime.now());
        orderForm.setUpdateTime(LocalDateTime.now());
        BeanUtils.copyProperties(request, orderForm);

        orderFormRepository.save(orderForm);

        // 扣库存
        stockClient.decr(request.getGoodsId(), request.getNum());

        return EOperation.SUCCESS;
    }

    @Override
    public ResultT<EOperation> retry() {
        return stockClient.retry();
    }
}
