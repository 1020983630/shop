package com.example.order.util;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class ExceptionUtil {
    public static String handleException(BlockException e) {
        return "block handler class";
    }
}
