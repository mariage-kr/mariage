package com.multi.mariage.like.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum LikeErrorCode implements ErrorCode {
    REVIEW_ALREADY_LIKED(400, "Like_01", "이미 좋아요한 리뷰입니다."),
    REVIEW_NOT_LIKED(404, "Like_02", "좋아요한 리뷰가 아닙니다."),
    LIKE_NOT_FOUND_IN_MEMBER(404, "Like_03", "멤버의 좋아요 리스트에 해당 좋아요가 없습니다."),
    LIKE_NOT_FOUND_IN_REVIEW(404, "Like_04", "리뷰에 해당 좋아요가 없습니다."),
    LIKE_NOT_CANCELED_IN_MEMBER(400, "Like_05", "좋아요가 취소되지 않았습니다."),
    LIKE_NOT_CANCELED_IN_REVIEW(400, "Like_06", "리뷰에서 좋아요를 취소하는 데 실패하였습니다.");
    private int statusCode;
    private String errorCode;
    private String message;

    LikeErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
