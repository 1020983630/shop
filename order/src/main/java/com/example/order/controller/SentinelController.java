package com.example.order.controller;

import com.example.order.service.SentinelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sentinel")
public class SentinelController {
    @Autowired
    private SentinelService sentinelService;

    @GetMapping("/blockHandler")
    public String blockHandler() {
        return sentinelService.blockHandler();
    }

    @GetMapping("/blockHandlerClass")
    public String blockHandlerClass() {
        return sentinelService.blockHandlerClass();
    }

    @GetMapping("/fallback")
    public String fallback() {
        return sentinelService.fallback();
    }

    @GetMapping("/limitThreadCount")
    public String limitThreadCount() {
        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                sentinelService.limitThreadCount();
//            });
            sentinelService.limitThreadCount();
        }
        return "success";
    }

    @GetMapping("/limitQps")
    public String limitQps() {
        for (int i = 0; i < 1; i++) {
//            new Thread(() -> {
//                sentinelService.limitThreadCount();
//            });
            sentinelService.limitQps();
        }
        return "success";
    }
}
