package com.example.stock.controller;

import com.example.common.dto.ResultT;
import com.example.common.enums.EOperation;
import com.example.stock.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PutMapping("/decr")
    public ResultT<EOperation> decr(String goodsId, int num) throws InterruptedException {
        log.info("+++++++++++++++++++++++");
        Thread.sleep(6000);
        EOperation eOperation = stockService.decr(goodsId, num);
        return ResultT.success(eOperation);
    }

    @GetMapping("/retry")
    public ResultT<EOperation> retry() throws InterruptedException {
        log.info("----------------");
//        Thread.sleep(6000);
        int err = 1 / 0;
        return ResultT.success(EOperation.SUCCESS);
    }
}
