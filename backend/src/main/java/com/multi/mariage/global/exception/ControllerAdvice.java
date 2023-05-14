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

    //    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException() {
//        return convert(GlobalErrorCode.CLIENT_WRONG_REQUEST);
//    }
//
//    @ExceptionHandler({NoHandlerFoundException.class, MethodArgumentTypeMismatchException.class})
//    public ResponseEntity<ExceptionResponse> notSupportedUriException() {
//        return convert(GlobalErrorCode.NOT_SUPPORTED_METHOD_ERROR);
//    }
//
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public ResponseEntity<ExceptionResponse> notSupportedMethodException() {
//        return convert(GlobalErrorCode.NOT_SUPPORTED_METHOD_ERROR);
//    }
//

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ExceptionResponse> handleAnyException() {
//        return convert(GlobalErrorCode.INTERNAL_SERVER_ERROR);
//    }
//
//    private ResponseEntity<ExceptionResponse> convert(ErrorCode code) {
//        int statusCode = code.getStatusCode();
//        ExceptionResponse response = ExceptionResponse.from(code.getMessage());
//
//        return ResponseEntity.status(statusCode).body(response);
//    }
}
