package com.multi.mariage.product.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import com.multi.mariage.global.exception.exception.MariageException;

public class ProductException extends MariageException {
    public ProductException(ErrorCode code) {
        super(code);
    }
}
