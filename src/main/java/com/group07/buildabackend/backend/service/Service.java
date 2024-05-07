package com.group07.buildabackend.backend.service;

import com.group07.buildabackend.backend.controller.Response;

public abstract class Service {
    public static <T> void handleException(Response<T> response, String message, int statusCode) {
        response.setResponseMsg(message);
        response.setStatusCode(statusCode);
        response.setData(null);
    }

    public static <T> void handleSuccess(Response<T> response, String message, int statusCode, T data) {
        response.setResponseMsg(message);
        response.setStatusCode(statusCode);
        response.setData(data);
    }
}
