package com.multi.mariage.global.exception;

import com.multi.mariage.global.exception.dto.response.ExceptionResponse;
import com.multi.mariage.global.exception.exception.MariageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MariageException.class)
    public ResponseEntity<ExceptionResponse> handleException(MariageException e) {
        int statusCode = e.getStatusCode();
        ExceptionResponse response = ExceptionResponse.from(e.getMessage());

        return ResponseEntity.status(statusCode).body(response);
    }
}
