package com.icf.tsmp.common.model;

/**
 * @auhther Arvin
 * @date 2020/7/2 15:26
 * @description:
 */
public class Result<T> extends BaseResult {
    //业务请求参数
    T ywxysj;

    public Result() {
    }

    public Result(long zts, T list) {
        this.setYwxysj(list);
    }

    public Result<T> data(T data) {
        this.setYwxysj(data);
        return this;
    }

    public T getYwxysj() {
        return ywxysj;
    }

    public void setYwxysj(T ywxysj) {
        this.ywxysj = ywxysj;
    }
    public Result<T> success(T data) {
        return this.data(data);
    }

    public Result<T> success(String message, T data) {
        this.data(data);
        this.setFhmsxx(message);
        return this;
    }

    public Result<T> fail(String message) {
        this.setFhmsxx(message);
        return this;
    }

    public Result<T> fail(String errorCode, String message) {
        this.setFhm(errorCode);
        return this;
    }

    public boolean success() {
        return this.getFhm().equals(super.fhm);
    }
}
