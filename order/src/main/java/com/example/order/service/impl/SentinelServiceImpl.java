package com.example.order.service.impl;

import com.alibaba.csp.sentinel.Tracer;
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
    @SentinelResource(value = "blockHandler", blockHandler = "exceptionHandler")
    public String blockHandler() {
        try {
            int i = 1 / 0;
        } catch (BlockException e){

        } catch (Throwable t) {
            Tracer.trace(t);
        }
        return SUCCESS;
    }

    @Override
    @SentinelResource(value = "blockHandler", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    public String blockHandlerClass() {
        return SUCCESS;
    }

    @Override
    public String fallback() {
        return SUCCESS;
    }

    public String exceptionHandler() {
        log.info("exceptionHandler----------");
        return "block handler";
    }

    public String exceptionFallback() {
        return "fallback";
    }
}
