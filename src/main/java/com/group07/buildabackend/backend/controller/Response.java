package com.group07.buildabackend.backend.controller;

public class Response<T> {
    private T data;
    private boolean isOk = true;
    private String responseMsg;
    private int statusCode;

    public Response(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
