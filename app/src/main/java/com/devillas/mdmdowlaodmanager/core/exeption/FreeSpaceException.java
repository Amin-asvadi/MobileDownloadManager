package com.devillas.mdmdowlaodmanager.core.exeption;

public class FreeSpaceException extends Exception {
    public FreeSpaceException() {
    }

    public FreeSpaceException(String message) {
        super(message);
    }

    public FreeSpaceException(Exception e) {
        super(e.getMessage());
        super.setStackTrace(e.getStackTrace());
    }
}
