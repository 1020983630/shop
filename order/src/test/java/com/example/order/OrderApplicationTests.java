package com.example.order;

import com.alibaba.fastjson.JSON;
import com.example.order.pojo.OrderForm;
import com.example.order.service.OrderFormService;
import com.example.order.vo.OrderFormVO;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class OrderApplicationTests {
    @Autowired
    private OrderFormService orderFormService;

    @Test
    void contextLoads() {
    }

    @Test
    void testJpa() {
        OrderFormVO orderFormVO = orderFormService.getById("123");
        System.out.println(JSON.toJSONString(orderFormVO));
    }
}
