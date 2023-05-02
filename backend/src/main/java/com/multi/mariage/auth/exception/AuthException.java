package com.multi.mariage.auth.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import com.multi.mariage.global.exception.exception.MariageException;

public class AuthException extends MariageException {
    public AuthException(ErrorCode code) {
        super(code);
    }
}
