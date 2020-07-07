package com.example.stock.controller;

import com.example.common.dto.ResultT;
import com.example.common.enums.EOperation;
import com.example.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PutMapping("/decr")
    public ResultT<EOperation> decr(String goodsId, int num) {
        EOperation eOperation = stockService.decr(goodsId, num);
        return ResultT.success(eOperation);
    }
}
