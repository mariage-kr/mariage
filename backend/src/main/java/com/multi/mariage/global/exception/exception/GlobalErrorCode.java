package com.multi.mariage.global.exception.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum GlobalErrorCode implements ErrorCode {
    CLIENT_WRONG_REQUEST(400, "ERROR_01", "잘못된 요청입니다."),
    NOT_SUPPORTED_URI_ERROR(404, "ERROR_02", "지원하지 않는 URI 요청입니다."),
    NOT_SUPPORTED_METHOD_ERROR(405, "ERROR_03", "지원하지 않는 메서드 요청입니다."),
    INTERNAL_SERVER_ERROR(500, "ERROR_04", "서버 오류 입니다.");

    private int statusCode;
    private String errorCode;
    private String message;

    GlobalErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
