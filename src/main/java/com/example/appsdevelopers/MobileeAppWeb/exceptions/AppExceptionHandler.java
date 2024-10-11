package com.example.appsdevelopers.MobileeAppWeb.exceptions;

import com.example.appsdevelopers.MobileeAppWeb.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

        String errorMessage = ex.getLocalizedMessage();

        if (errorMessage == null) {
            errorMessage = ex.toString();
        }

        ErrorMessage error = new ErrorMessage(new Date(), errorMessage);

        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {

        String errorMessage = ex.getLocalizedMessage();

        if (errorMessage == null) {
            errorMessage = ex.toString();
        }

        ErrorMessage error = new ErrorMessage(new Date(), errorMessage);

        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {

        String errorMessage = ex.getLocalizedMessage();

        if (errorMessage == null) {
            errorMessage = ex.toString();
        }

        ErrorMessage error = new ErrorMessage(new Date(), errorMessage);

        // Response
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
