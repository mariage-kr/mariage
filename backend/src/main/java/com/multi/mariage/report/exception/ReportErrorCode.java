package com.multi.mariage.report.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum ReportErrorCode implements ErrorCode {
    IS_ALREADY_REPORT(400, "REPORT_01", "이미 신고한 리뷰입니다.");

    private final int statusCode;
    private final String errorCode;
    private final String message;

    ReportErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
