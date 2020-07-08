package com.example.order.controller;

import com.example.common.dto.ResultT;
import com.example.order.service.OrderFormService;
import com.example.order.vo.OrderFormVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
