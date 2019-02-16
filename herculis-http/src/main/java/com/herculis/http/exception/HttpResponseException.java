package com.herculis.http.exception;

public class HttpResponseException extends RuntimeException {

    public HttpResponseException() {
    }

    public HttpResponseException(String message) {
        super(message);
    }

    public HttpResponseException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpResponseException(Throwable cause) {
        super(cause);
    }
    
}
