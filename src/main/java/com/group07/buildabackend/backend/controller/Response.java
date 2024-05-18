package com.group07.buildabackend.backend.controller;

/**
 * @author Group_7
 */

public class Response<T> {
    private T data;
    private String responseMsg;
    private int statusCode;
    private String action;

    public Response(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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

    public boolean isOk() {
        return statusCode >= 200 && statusCode <= 299;
    }
}
