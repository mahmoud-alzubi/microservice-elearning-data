package com.mtech.elearning.exceptions;

public class ElearningNotFoundException extends RuntimeException {
    public ElearningNotFoundException() {
    }

    public ElearningNotFoundException(String message) {
        super(message);
    }

    public ElearningNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElearningNotFoundException(Throwable cause) {
        super(cause);
    }

    public ElearningNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
