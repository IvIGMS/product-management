package com.ivanfrias.product_management.exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, Object... args) {
        super(String.format(message, args));
    }
}
