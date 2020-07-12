package com.example.order.service;

public interface SentinelService {
    String blockHandler();

    String blockHandlerClass();

    String fallback();

    String limitThreadCount();

    String limitQps();
}
