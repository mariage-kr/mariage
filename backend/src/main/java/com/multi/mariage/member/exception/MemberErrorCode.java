package com.multi.mariage.member.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum MemberErrorCode implements ErrorCode {
    EMAIL_PATTERN_MUST_BE_VALID(400, "EMAIL_01", "올바르지 않은 이메일 형식입니다."),
    EMAIL_ID_CANNOT_BE_OUT_OF_RANGE(400, "EMAIL_02", "이메일 계정의 길이는 최소 8자부터 최대 16자까지 허용합니다."),
    EMAIL_DOMAIN_NAME_CANNOT_BE_OUT_OF_RANGE(400, "EMAIL_03", "도메인 주소의 길이는 최소 2자부터 최대 63자까지 허용합니다."),
    NAME_PATTERN_MUST_BE_VALID(400, "NAME_01", "올바르지 않은 이름의 형식입니다."),
    NAME_CANNOT_BE_OUT_OF_RANGE(400, "NAME_02", "사용자의 이름은 2자 이상 30자 이하여야 합니다."),
    NICKNAME_PATTERN_MUST_BE_VALID(400, "NICKNAME_01", "올바르지 않은 닉네임의 형식입니다."),
    NICKNAME_CANNOT_BE_OUT_OF_RANGE(400, "NICKNAME_02", "닉네임은 2자 이상 12자 이하여야 합니다."),
    PASSWORD_PATTERN_MUST_BE_VALID(400, "PASSWORD_01", "올바르지 않은 비밀번호 형식입니다."),
    PASSWORD_CANNOT_BE_OUT_OF_RANGE(400, "PASSWORD_01", "비밀번호는 8자 이상 16자 이하여야 합니다."),
    SIGNUP_INVALID_EMAIL(400, "SIGNUP_01", "이미 가입된 이메일입니다."),
    MEMBER_IS_NOT_EXISTED(400, "MEMBER_01", "존재하지 않는 회원입니다."),
    MEMBER_IS_ALREADY_WITHDRAWAL(400, "MEMBER_02", "이미 탈퇴한 회원입니다."),
    MEMBER_HAS_NOT_PROFILE_IMAGE(400, "MEMBER_03", "회원의 프로필 이미지가 존재하지 않습니다."),
    MEMBER_WRONG_PASSWORD(400, "MEMBER_04", "잘못된 비밀번호 입니다."),
    MEMBER_PASSWORD_IS_SAME(400, "MEMBER_05", "현재 비밀번호와 새로운 비밀번호가 일치합니다.");
    private final int statusCode;
    private final String errorCode;
    private final String message;

    MemberErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
