package com.multi.mariage.review.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import com.multi.mariage.global.exception.exception.MariageException;

public class ReviewException extends MariageException {
    public ReviewException(ErrorCode code) {
        super(code);
    }
}
