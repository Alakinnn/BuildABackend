package com.group07.buildabackend.backend.validation.customExceptions;

public class InvalidInputException extends Exception{
    private final int errorCode;

    public InvalidInputException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
