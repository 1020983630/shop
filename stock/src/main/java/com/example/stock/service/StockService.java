package com.example.stock.service;

import com.example.common.enums.EOperation;

public interface StockService {

    /**
     * decr stock
     * @param num
     * @return
     */
    EOperation decr(String goodsId, int num);
}
