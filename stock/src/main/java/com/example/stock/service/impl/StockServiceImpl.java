package com.example.stock.service.impl;

import com.example.common.enums.EOperation;
import com.example.stock.repository.StockRepository;
import com.example.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public EOperation decr(String goodsId, int num) {
//        return stockRepository.decr(goodsId, num) > 0 ? EOperation.SUCCESS : EOperation.FAIL;
        int count = stockRepository.decr(goodsId, num);
        System.out.println("---------------" + count + "-------------");
        return count > 0 ? EOperation.SUCCESS : EOperation.FAIL;
    }
}
