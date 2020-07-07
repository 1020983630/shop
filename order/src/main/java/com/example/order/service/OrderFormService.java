package com.example.order.service;

import com.example.common.enums.EOperation;
import com.example.order.request.PlaceOrderRequest;
import com.example.order.vo.OrderFormVO;

public interface OrderFormService {
    OrderFormVO getById(String id);

    /**
     * place order
     * @param request
     */
    EOperation placeOrder(PlaceOrderRequest request);
}
