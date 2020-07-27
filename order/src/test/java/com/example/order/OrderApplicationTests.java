package com.example.order;

import com.alibaba.fastjson.JSON;
import com.example.order.pojo.DisLock;
import com.example.order.repository.DisLockRepository;
import com.example.order.request.PlaceOrderRequest;
import com.example.order.service.OrderFormService;
import com.example.order.service.SentinelService;
import com.example.order.vo.OrderFormVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class OrderApplicationTests {
    @Autowired
    private OrderFormService orderFormService;

    @Autowired
    private DisLockRepository disLockRepository;

    @Autowired
    private SentinelService sentinelService;

    @Test
    void contextLoads() {
    }

    @Test
    void testJpa() {
        OrderFormVO orderFormVO = orderFormService.getById("123");
        System.out.println(JSON.toJSONString(orderFormVO));
    }

    @Test
    void testPlaceOrder() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                PlaceOrderRequest request = new PlaceOrderRequest();
                request.setGoodsId("123");
                request.setAddressee("杨建辉");
                request.setMobile("17721015669");
                request.setAddress("上海市锦秋路");
                request.setNum(1);

                try {
                    orderFormService.placeOrder(request);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        Thread.currentThread().join();

//        PlaceOrderRequest request = new PlaceOrderRequest();
//        request.setGoodsId("123");
//        request.setAddressee("杨建辉");
//        request.setMobile("17721015669");
//        request.setAddress("上海市锦秋路");
//        request.setNum(1);
//        orderFormService.placeOrder(request);
    }

    @Test
    public void testLimitThreadCount() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                sentinelService.limitThreadCount();
            });
        }
        Thread.sleep(5000);
    }

    @Test
    public void testSave() {
        DisLock disLock = new DisLock("test1", "test1");
        disLockRepository.save(disLock);
        System.out.println(disLock);
    }
}
