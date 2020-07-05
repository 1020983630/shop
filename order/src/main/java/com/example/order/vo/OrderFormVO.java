package com.example.order.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderFormVO {
    private String addressee;
    private String mobile;
    private String address;
    private Short status;
    private Short payStatus;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
