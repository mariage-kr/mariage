package com.multi.mariage.report.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import com.multi.mariage.global.exception.exception.MariageException;

public class ReportException extends MariageException {
    public ReportException(ErrorCode code) {
        super(code);
    }
}
