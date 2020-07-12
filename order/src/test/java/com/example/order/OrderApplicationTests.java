//package com.example.order;
//
//import com.alibaba.fastjson.JSON;
//import com.example.order.request.PlaceOrderRequest;
//import com.example.order.service.OrderFormService;
//import com.example.order.service.SentinelService;
//import com.example.order.vo.OrderFormVO;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class OrderApplicationTests {
//    @Autowired
//    private OrderFormService orderFormService;
//
//    @Autowired
//    private SentinelService sentinelService;
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    void testJpa() {
//        OrderFormVO orderFormVO = orderFormService.getById("123");
//        System.out.println(JSON.toJSONString(orderFormVO));
//    }
//
//    @Test
//    void testPlaceOrder() {
//        PlaceOrderRequest request = new PlaceOrderRequest();
//        request.setGoodsId("123");
//        request.setAddressee("杨建辉");
//        request.setMobile("17721015669");
//        request.setAddress("上海市锦秋路");
//        request.setNum(2);
//
//        orderFormService.placeOrder(request);
//    }
//
//    @Test
//    public void testLimitThreadCount() throws InterruptedException {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                sentinelService.limitThreadCount();
//            });
//        }
//        Thread.sleep(5000);
//    }
//}
