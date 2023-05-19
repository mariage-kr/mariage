package com.multi.mariage.like.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import com.multi.mariage.global.exception.exception.MariageException;

public class LikeException extends MariageException {
    public LikeException(ErrorCode code) {
        super(code);
    }
}
