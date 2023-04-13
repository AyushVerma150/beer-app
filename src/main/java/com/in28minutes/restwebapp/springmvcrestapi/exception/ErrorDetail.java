package com.in28minutes.restwebapp.springmvcrestapi.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorDetail {
    private HttpStatus status;
    private String error;
    private Map<String,String> fieldErrors;
    private String message;
    private LocalDateTime timeStamp;
    private String path;

    public
    ErrorDetail(HttpStatus status, String error, Map<String,String> fieldErrors, String message, LocalDateTime timeStamp, String path) {
        this.status = status;
        this.error = error;
        this.fieldErrors = fieldErrors;
        this.message = message;
        this.timeStamp = timeStamp;
        this.path = path;
    }

    public
    Map<String,String> getFieldErrors() {
        return fieldErrors;
    }

    public
    void setFieldErrors(Map<String,String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}