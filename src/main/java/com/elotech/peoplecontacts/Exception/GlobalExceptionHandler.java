package com.elotech.peoplecontacts.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException ex, WebRequest req)
    {
        ErroDetails erroDetails = new ErroDetails(new Date(), ex.getMessage(),req.getDescription(false));
        return new ResponseEntity<>(erroDetails, HttpStatus.NOT_FOUND);
    }
}
