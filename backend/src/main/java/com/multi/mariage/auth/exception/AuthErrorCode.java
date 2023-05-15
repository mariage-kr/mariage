package com.multi.mariage.auth.exception;


import com.multi.mariage.global.exception.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum AuthErrorCode implements ErrorCode {
    TOKEN_WITHOUT_AUTHORIZATION_INFORMATION(400, "AUTH_01", "권한 정보가 없는 토큰입니다."),
    JWT_SIGNATURE_MUST_BE_VALID(401, "AUTH_02", "잘못된 JWT 서명입니다."),
    JWT_MUST_BE_NOT_EXPIRED(401, "AUTH_03", "만료된 JWT 토큰입니다"),
    JWT_NOT_SUPPORT(401, "AUTH_04", "지원되지 않는 JWT 토큰입니다"),
    JWT_BE_MUST_VALID(401, "AUTH_05", "잘못된 JWT 토큰입니다."),
    AUTH_MUST_BE_VALID(401, "AUTH_06", "올바르지 않은 인증입니다."),
    AUTH_PERMISSION_TO_ACCESS_THE_REQUEST_ROLE(403, "AUTH_07", "요청하신 기능에 접근할 권한이 없습니다."),
    CONTEXT_HAS_NOT_CONTAIN_AUTH_INFORMATION(401, "AUTH_08", "인증 정보가 없습니다."),
    MEMBER_EMAIL_IS_NOT_EXIST(400, "AUTH_09", "해당이메일로 가입된 사용자는 존재하지 않습니다."),
    REFRESH_TOKEN_MUST_BE_VALID(400, "AUTH_10", "Refresh Token 이 유효하지 않습니다."),
    MEMBER_IS_ALREADY_LOGOUT(400, "AUTH_11", "로그아웃 된 사용자입니다."),
    TOKEN_MEMBER_INFORMATION_IS_NOT_SAME(400, "AUTH_12", "토큰의 유저 정보가 동일하지 않습니다.");

    private final int statusCode;
    private final String errorCode;
    private final String message;

    AuthErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}