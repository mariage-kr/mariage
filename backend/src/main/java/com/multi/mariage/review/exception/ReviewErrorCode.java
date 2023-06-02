package com.multi.mariage.review.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum ReviewErrorCode implements ErrorCode {
    REVIEW_IS_NOT_EXISTED(400, "REVIEW_01", "리뷰가 존재하지 않습니다.");

    private int statusCode;
    private String errorCode;
    private String message;

    ReviewErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
