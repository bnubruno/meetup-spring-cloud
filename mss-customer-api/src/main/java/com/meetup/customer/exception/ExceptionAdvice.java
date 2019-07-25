package com.meetup.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionAdvice {

    private static final String ERROR_DESCRIPTION = "Por favor, preencha o formulário corretamente.";
    private static final String DEFAULT_ERROR_TITLE = "Informações inválidas";
    private static final String SPACE = " ";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public RestResponse onError(ConstraintViolationException ex) {
        List<String> errors = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return new RestResponse(HttpStatus.BAD_REQUEST, DEFAULT_ERROR_TITLE, ERROR_DESCRIPTION, errors);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public RestResponse onError(MethodArgumentNotValidException ex) {
        List<String> list = ex.getBindingResult().getFieldErrors().stream()
                .map(f -> f.getField() + SPACE + f.getDefaultMessage())
                .collect(Collectors.toList());
        return new RestResponse(HttpStatus.BAD_REQUEST, DEFAULT_ERROR_TITLE, ERROR_DESCRIPTION, list);
    }


}
