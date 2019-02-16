package com.herculis.http.exception;

public class UnsupportedHttpMethodException extends RuntimeException {

    public UnsupportedHttpMethodException() {
    }

    public UnsupportedHttpMethodException(String message) {
        super(message);
    }

    public UnsupportedHttpMethodException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedHttpMethodException(Throwable cause) {
        super(cause);
    }

}
