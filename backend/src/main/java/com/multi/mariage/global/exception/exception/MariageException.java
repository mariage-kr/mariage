package com.multi.mariage.global.exception.exception;

import lombok.Getter;

@Getter
public class MariageException extends RuntimeException {
    private final int statusCode;
    private final String errorCode;
    private final String message;

    public MariageException(ErrorCode code) {
        this.statusCode = code.getStatusCode();
        this.errorCode = code.getErrorCode();
        this.message = code.getMessage();
    }
}
