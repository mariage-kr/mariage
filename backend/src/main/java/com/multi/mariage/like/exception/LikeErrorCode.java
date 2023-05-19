package com.multi.mariage.like.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum LikeErrorCode implements ErrorCode {
    REVIEW_ALREADY_LIKED(400, "Like_01", "이미 좋아요한 리뷰입니다.");
    private int statusCode;
    private String errorCode;
    private String message;

    LikeErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
