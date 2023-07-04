package com.mtech.elearning.exceptions;

public class InstructorNotFoundException extends ElearningNotFoundException {
    public InstructorNotFoundException() {
    }

    public InstructorNotFoundException(String message) {
        super(message);
    }

    public InstructorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public InstructorNotFoundException(Throwable cause) {
        super(cause);
    }

    public InstructorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
