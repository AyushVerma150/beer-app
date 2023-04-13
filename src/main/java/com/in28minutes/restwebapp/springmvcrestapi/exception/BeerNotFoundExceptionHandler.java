package com.in28minutes.restwebapp.springmvcrestapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND ,value = HttpStatus.NOT_FOUND)
public class BeerNotFoundExceptionHandler extends RuntimeException {

    public BeerNotFoundExceptionHandler(String reason) {
        super(reason);
    }
}