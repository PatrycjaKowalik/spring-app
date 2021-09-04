package com.wine.wines;

public class WineNotFoundException extends Throwable {
    public WineNotFoundException(String message) {
        super(message);
    }
}
