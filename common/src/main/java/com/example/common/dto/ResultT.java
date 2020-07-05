package com.example.common.dto;

import lombok.Data;

@Data
public class ResultT<T> {
    private int code;
    private String msg;
    private T data;

    /**
     * 成功时候的调用
     * */
    public static <T> ResultT<T> success(T data){
        return new ResultT<T>(data);
    }

    /**
     * 失败时候的调用
     * */
    public static <T> ResultT<T> error(int code, String msg){
        return new ResultT<T>(code, msg);
    }

    private ResultT(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    private ResultT(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    public T getData() {
        return data;
    }
}
