package com.group07.buildabackend.backend.validation.customExceptions;
/**
 * @author Group_7
 */
public class BadFormatException extends Exception{
    private final int errorCode;

    public BadFormatException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}