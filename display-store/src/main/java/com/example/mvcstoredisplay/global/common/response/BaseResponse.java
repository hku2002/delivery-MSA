package com.example.mvcstoredisplay.global.common.response;

import lombok.Getter;

@Getter
public class BaseResponse<T> {

    private String status;
    private String message;
    private T data;

    public BaseResponse() {
        this.status = "success";
        this.message = "";
    }

    public BaseResponse(T data) {
        this.status = "success";
        this.message = "";
        this.data = data;
    }

    public BaseResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }


}
