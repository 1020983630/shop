package com.example.order.service.impl;

import com.example.common.dto.ResultT;
import com.example.common.enums.EOperation;
import com.example.order.feign.StockClient;
import com.example.order.pojo.OrderForm;
import com.example.order.repository.DisLockRepository;
import com.example.order.repository.OrderFormRepository;
import com.example.order.request.PlaceOrderRequest;
import com.example.order.service.OrderFormService;
import com.example.order.vo.OrderFormVO;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class OrderFormServiceImpl implements OrderFormService {
    @Autowired
    private OrderFormRepository orderFormRepository;

    @Autowired
    private DisLockRepository disLockRepository;

    @Autowired
    private StockClient stockClient;

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public OrderFormVO getById(String id) {
        OrderFormVO orderFormVO = new OrderFormVO();
        Optional<OrderForm> orderForm = orderFormRepository.findById(id);

        BeanUtils.copyProperties(orderForm.get(), orderFormVO);

        return orderFormVO;
    }

    /**
     * mysql lock
     * @param request
     * @return
     * @throws Exception
     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public EOperation placeOrder(PlaceOrderRequest request) throws Exception {
//        // 加锁
//        // mysql lock
//        DisLock lock = new DisLock("placeOrder", "placeOrder");
//
//        try {
//            while (lock.getId() == null || lock.getId() <= 0) {
//                try {
//                    disLockRepository.save(lock);
//                } catch (Exception e) {
//
//                }
//            }
//
//            OrderForm orderForm = new OrderForm();
//            orderForm.setId(UUID.randomUUID().toString().replace("-", ""));
//            orderForm.setCreateTime(LocalDateTime.now());
//            orderForm.setUpdateTime(LocalDateTime.now());
//            BeanUtils.copyProperties(request, orderForm);
//
//            orderFormRepository.save(orderForm);
//
//            // 扣库存
//            ResultT<EOperation> resultT = stockClient.decr(request.getGoodsId(), request.getNum());
//            if (resultT.getData() == EOperation.FAIL) {
//                throw new Exception("扣减失败");
//            }
//
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            // 释放锁
//            disLockRepository.delete(lock);
//        }
//
//        return EOperation.SUCCESS;
//    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EOperation placeOrder(PlaceOrderRequest request) throws Exception {
        // 加锁
//        RLock rLock = redissonClient.getLock("order" + ":" + request.getGoodsId());
//        if (rLock.tryLock(3l, 3l, TimeUnit.SECONDS)) {
//            try {
                OrderForm orderForm = new OrderForm();
                orderForm.setId(UUID.randomUUID().toString().replace("-", ""));
                orderForm.setCreateTime(LocalDateTime.now());
                orderForm.setUpdateTime(LocalDateTime.now());
                BeanUtils.copyProperties(request, orderForm);

                orderFormRepository.save(orderForm);

                // 扣库存
                ResultT<EOperation> resultT = stockClient.decr(request.getGoodsId(), request.getNum());
                if (resultT.getData() == EOperation.FAIL) {
                    throw new Exception("扣减失败");
                }
//            } catch (Exception e) {
//                throw e;
//            } finally {
//                rLock.unlock();
//            }
//        }

        return EOperation.SUCCESS;
    }

    @Override
    public ResultT<EOperation> retry() {
        return stockClient.retry();
    }
}
