package com.multi.mariage.product.domain.embedded;

import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Info {
    private static final int MAX_LENGTH = 500;
    @Lob
    @Column(name = "info", length = 500)
    private String value;


    private Info(String value) {
        this.value = value;
    }

    public static Info of(String value) {
        validateLengthInRange(value);
        return new Info(value);
    }

    private static void validateLengthInRange(String value) {
        if (MAX_LENGTH < value.length()) {
            throw new ProductException(ProductErrorCode.INFO_CANNOT_BE_OUT_OF_RANGE);
        }
    }
}

