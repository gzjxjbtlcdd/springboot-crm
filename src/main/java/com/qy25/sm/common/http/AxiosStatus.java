package com.qy25.sm.common.http;

public enum  AxiosStatus {
    OK(1000,"成功"),
    ERROR(2000,"失败")

    ;
    private int status;

    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    AxiosStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    AxiosStatus() {
    }
}
