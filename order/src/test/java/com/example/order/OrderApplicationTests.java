package com.example.order;

import com.alibaba.fastjson.JSON;
import com.example.order.pojo.DisLock;
import com.example.order.repository.DisLockRepository;
import com.example.order.request.PlaceOrderRequest;
import com.example.order.service.OrderFormService;
import com.example.order.service.SentinelService;
import com.example.order.vo.OrderFormVO;
import org.junit.jupiter.api.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
        ExecutorService executorService = Executors.newFixedThreadPool(100);
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

    @Autowired
    private RedissonClient client;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedisson() {
        RBucket<Object> rBucket = client.getBucket("redisson");
        rBucket.set("test");

        RBucket<Object> rBucket1 = client.getBucket("redisson");
        Object o = rBucket1.get();
        System.out.println(o.toString());

        ValueOperations set = redisTemplate.opsForValue();
        set.set("redisson1", "test1");

        Object redisson1 = redisTemplate.opsForValue().get("redisson1");
        System.out.println(redisson1.toString());
    }

    private int count = 0;

    public void addCount() throws InterruptedException {
        RLock rLock = client.getLock("lock");
        if (rLock.tryLock(3l, 3l, TimeUnit.SECONDS)) {
            try {
                count++;
            } catch (Exception e) {
                addError();
            } finally {
                rLock.unlock();
            }
        } else {
            addError();
        }
    }

    private int error = 0;
    public synchronized void addError() {
        error++;
    }

    @Test
    public void testDistributionLock() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100000; i++) {
            executorService.execute(() -> {
                try {
                    addCount();
                } catch (InterruptedException e) {
//                    addError();
                }
            });
        }

        int tmp = -1;
        while (true) {
            Thread.sleep(1000 * 10);
            System.out.println("count: " + count);
            System.out.println("error: " + error);

            if (tmp == count) {
                break;
            }
            tmp = count;
        }

    }
}
