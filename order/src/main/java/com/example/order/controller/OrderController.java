package com.example.order.controller;

import com.example.common.dto.ResultT;
import com.example.order.request.PlaceOrderRequest;
import com.example.order.service.OrderFormService;
import com.example.order.vo.OrderFormVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequestMapping("/order")
@RestController
@RefreshScope
public class OrderController {
    //    https://www.cnblogs.com/cicada-smile/p/12544279.html
    @Autowired
    private OrderFormService orderFormService;

    @GetMapping("/{id}")
    public ResultT<OrderFormVO> getById(@PathVariable String id) {
        OrderFormVO orderFormVO = orderFormService.getById(id);
        return ResultT.success(orderFormVO);
    }

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @RequestMapping("/get")
    public boolean get() {
        return useLocalCache;
    }

    @GetMapping("/decr")
    public String decr() throws Exception {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 100; i++) {
//            executorService.execute(() -> {
//                PlaceOrderRequest request = new PlaceOrderRequest();
//                request.setGoodsId("123");
//                request.setAddressee("杨建辉");
//                request.setMobile("17721015669");
//                request.setAddress("上海市锦秋路");
//                request.setNum(1);
//
//            orderFormService.placeOrder(request);
//            });
//        }

        PlaceOrderRequest request = new PlaceOrderRequest();
        request.setGoodsId("123");
        request.setAddressee("杨建辉");
        request.setMobile("17721015669");
        request.setAddress("上海市锦秋路");
        request.setNum(2);

        orderFormService.placeOrder(request);

        return "success";
    }

    @GetMapping("/retry")
    public String retry() {
        orderFormService.retry();
        return "success";
    }
}
