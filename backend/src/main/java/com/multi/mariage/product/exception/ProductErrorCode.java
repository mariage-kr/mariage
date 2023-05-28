package com.multi.mariage.product.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum ProductErrorCode implements ErrorCode {
    NAME_CANNOT_BE_OUT_OF_RANGE(400, "NAME_01", "제품의 이름은 1자 이상 40자 이하여야 합니다."),
    LEVEL_PATTERN_MUST_BE_VALID(400, "LEVEL_01", "올바르지 않은 도수 형식입니다."),
    LEVEL_CANNOT_BE_OUT_OF_RANGE(400, "LEVEL_02", "도수는 0.001에서 100 범위 내에 있어야 합니다."),
    INFO_CANNOT_BE_OUT_OF_RANGE(400, "INFO_01", "제품의 정보는 500자 이하여야 합니다."),
    SAVE_INVALID_PRODUCT(400, "SAVE_01", "이미 존재하는 제품입니다."),
    PRODUCT_IS_NOT_EXIST(400, "PRODUCT_01", "제품이 존재하지 않습니다."),
    REVIEW_SCORE_CANNOT_BE_OUT_OF_RANGE(400, "SCORE_01", "제품에 대한 리뷰의 별점은 1점에서 5점 범위 내에 있어야 합니다.");

    private final int statusCode;
    private final String errorCode;
    private final String message;

    ProductErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
