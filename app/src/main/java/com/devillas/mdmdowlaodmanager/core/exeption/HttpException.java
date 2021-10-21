package com.devillas.mdmdowlaodmanager.core.exeption;

public class HttpException extends Exception {
    private final int responseCode;

    public HttpException(String message) {
        this(message, 0);
    }

    public HttpException(String message, int responseCode) {
        super(message);
        this.responseCode = responseCode;
    }
    public HttpException(String message, int responseCode,Exception e) {
        super(message);
        this.responseCode = responseCode;
        initCause(e);
    }
public int getResponseCode() {
return responseCode;
}

}
