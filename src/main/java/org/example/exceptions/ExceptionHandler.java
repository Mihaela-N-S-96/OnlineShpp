package org.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value =
            {okResponse.class})
    public ResponseEntity<Object> handleException(okResponse e){
        HttpStatus okRequest = HttpStatus.OK;

        Exception okException = new Exception(
                e.getMessage(),
                okRequest,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(okException,okRequest);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value =
            {InvalidProductException.class})
    public ResponseEntity<Object> invalidProductException(InvalidProductException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        Exception invalidException = new Exception(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(invalidException, badRequest);
    }
}
