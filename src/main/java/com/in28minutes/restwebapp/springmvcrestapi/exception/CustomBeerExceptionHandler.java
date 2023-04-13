package com.in28minutes.restwebapp.springmvcrestapi.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class CustomBeerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class) public final
    ResponseEntity<ErrorDetail> handleExceptions(Exception ex, @NotNull HttpServletRequest request) throws Exception {
        return new ResponseEntity<>(new ErrorDetail(HttpStatus.NOT_FOUND,
                ex.getMessage(),
                null,
                null,
                LocalDateTime.now(),
                request.getRequestURI()),
                HttpStatus.NOT_FOUND);
    }


    @Override
    protected final
    ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, @NotNull HttpHeaders headers, @NotNull HttpStatusCode status, WebRequest request) {
        Map<String, String> errDetails = new HashMap<>();
        ex.getBindingResult()
        .getFieldErrors()
        .forEach( fieldError -> errDetails.put( fieldError.getField() , fieldError.getDefaultMessage() ));
        return new ResponseEntity<>( new ErrorDetail( HttpStatus.BAD_REQUEST,
                "Bad Request",
                errDetails,
                null,
                LocalDateTime.now(),
                ((ServletWebRequest)request).getRequest().getRequestURI().toString() ),
                status );
    }



}