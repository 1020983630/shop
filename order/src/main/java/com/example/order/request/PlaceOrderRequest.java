package com.example.order.request;

import lombok.Data;

@Data
public class PlaceOrderRequest {

    private String goodsId;
    private String addressee;
    private String mobile;
    private String address;
    private int num;

}
