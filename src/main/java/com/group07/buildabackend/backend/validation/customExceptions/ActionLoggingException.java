package com.group07.buildabackend.backend.validation.customExceptions;

public class ActionLoggingException extends Exception{
    private final int errorCode;

    public ActionLoggingException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
