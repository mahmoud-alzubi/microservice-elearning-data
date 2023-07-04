package com.mtech.elearning.exceptions;

public class InstructorDetailNotFoundException extends ElearningNotFoundException {
    public InstructorDetailNotFoundException() {
    }

    public InstructorDetailNotFoundException(String message) {
        super(message);
    }

    public InstructorDetailNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public InstructorDetailNotFoundException(Throwable cause) {
        super(cause);
    }

    public InstructorDetailNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
