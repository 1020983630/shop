package com.example.order.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.order.service.SentinelService;
import com.example.order.util.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SentinelServiceImpl implements SentinelService {
    private final String SUCCESS = "success";

    @Override
    @SentinelResource(value = "blockHandler", blockHandler = "exceptionHandler", fallback = "exceptionFallback")
    public String blockHandler() {
        if (true) {
            throw new RuntimeException();
        }
        return SUCCESS;
    }

    @Override
    @SentinelResource(value = "blockHandlerClass", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    public String blockHandlerClass() {
        if (true) {
            throw new RuntimeException();
        }
        return SUCCESS;
    }

    @Override
    public String fallback() {
        return SUCCESS;
    }

    public String exceptionHandler(BlockException e) {
        log.info("exceptionHandler----------" + e);
        return "block handler";
    }

    public String exceptionFallback() {
        return "fallback";
    }

    private int i = 0;

    @Override
    @SentinelResource(value = "limitThreadCount")
    public String limitThreadCount() {
        log.info("-------------第" + i++ + "次调用-----------");
        return SUCCESS;
    }

    @Override
//    @SentinelResource(value = "limitQps")
    public String limitQps() {
        log.info("-------------第" + i++ + "次调用-----------");
        return SUCCESS;
    }
}
