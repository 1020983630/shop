package com.example.order;

import com.example.order.pojo.Order;
import com.example.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class OrderApplicationTests {
    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
    }

    @Test
    void testJpa() {
        Optional<Order> order = orderService.getById("");
        System.out.println(order);
    }
}
