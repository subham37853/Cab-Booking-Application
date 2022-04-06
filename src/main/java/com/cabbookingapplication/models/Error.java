package com.cabbookingapplication.models;

public class Error {
    private final String message;
    private final int code;

    public Error(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
