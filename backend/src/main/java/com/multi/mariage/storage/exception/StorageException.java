package com.multi.mariage.storage.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import com.multi.mariage.global.exception.exception.MariageException;

public class StorageException extends MariageException {
    public StorageException(ErrorCode code) {
        super(code);
    }
}
