package com.example.stock;

import com.example.stock.service.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StockApplicationTests {

    @Autowired
    private StockService stockService;

    @Test
    void contextLoads() {
    }

    @Test
    public void decr() {
        stockService.decr("123", 2);
    }

}
