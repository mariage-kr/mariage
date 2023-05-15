package com.multi.mariage.product.exception;


import com.multi.mariage.global.exception.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum ProductErrorCode implements ErrorCode {
    PRODUCT_IS_NOT_EXIST(400, "PRODUCT_01", "제품이 존재하지 않습니다.");

    private int statusCode;
    private String errorCode;
    private String message;

    ProductErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
