package com.multi.mariage.product.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum ProductErrorCode implements ErrorCode {
    NAME_PATTERN_MUST_BE_VALID(400, "NAME_01", "올바르지 않은 제품 이름 형식입니다."),
    NAME_CANNOT_BE_OUT_OF_RANGE(400, "NAME_02", "제품의 이름은 1자 이상 40자 이하여야 합니다."),
    LEVEL_PATTERN_MUST_BE_VALID(400, "LEVEL_01", "올바르지 않은 도수 형식입니다."),
    LEVEL_CANNOT_BE_OUT_OF_RANGE(400, "LEVEL_02", "도수는 0.001에서 100 범위 내에 있어야 합니다."),
    INFO_PATTERN_MUST_BE_VALID(400, "INFO_01", "올바르지 않은 제품 정보 형식입니다."),
    INFO_CANNOT_BE_OUT_OF_RANGE(400, "INFO_02", "제품의 정보는 150자 이하여야 합니다."),
    SAVE_INVALID_PRODUCT(400, "SAVE_01", "이미 존재하는 제품입니다.");

    private final int statusCode;
    private final String errorCode;
    private final String message;

    ProductErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
