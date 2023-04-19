package com.dream.medicalservice.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Result<T> {

    private String code;
    private String msg;
    T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }
    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
