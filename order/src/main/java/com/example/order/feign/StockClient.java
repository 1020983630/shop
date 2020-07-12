package com.example.order.feign;

import com.example.common.dto.ResultT;
import com.example.common.enums.EOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "stock")
public interface StockClient {

    @PutMapping("/stock/decr")
    ResultT<EOperation> decr(@RequestParam String goodsId, @RequestParam int num);

    @GetMapping("/stock/retry")
    ResultT<EOperation> retry();
}
