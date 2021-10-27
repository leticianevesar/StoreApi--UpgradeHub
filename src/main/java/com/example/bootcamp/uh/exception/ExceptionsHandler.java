package com.example.bootcamp.uh.exception;

import com.example.bootcamp.uh.controller.response.HttpErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

public class ExceptionsHandler {
    @ExceptionHandler({CustomerNotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpErrorResponse handleGenericException(CustomerNotFound exception) {
        return new HttpErrorResponse(
                404,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }
    @ExceptionHandler({PurchaseNotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpErrorResponse handleGenericException(PurchaseNotFound exception) {
        return new HttpErrorResponse(
                404,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }
}

