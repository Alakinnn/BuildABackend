package com.group07.buildabackend.backend.validation.customExceptions;
/**
 * @author Group_7
 */

public class InvalidCredentialsException extends Exception{
    private final int errorCode;

    public InvalidCredentialsException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
