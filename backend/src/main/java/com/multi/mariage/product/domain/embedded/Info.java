package com.multi.mariage.product.domain.embedded;

import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Info {
    private static final String INFO_FORMAT = "^.{1,150}$";
    private static final Pattern INFO_PATTERN = Pattern.compile(INFO_FORMAT);
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 150;
    @Column(name = "info", nullable = false, unique = true)
    private String value;


    private Info(String value) {
        this.value = value;
    }

    public static Info of(String value) {
        validateLengthInRange(value);
        validatePatternIsValid(value);
        return new Info(value);
    }

    private static void validateLengthInRange(String value) {
        int length = value.length();
        if (length < MIN_LENGTH || MAX_LENGTH < length) {
            throw new ProductException(ProductErrorCode.INFO_CANNOT_BE_OUT_OF_RANGE);
        }
    }

    private static void validatePatternIsValid(String value) {
        if (isNotValid(value)) {
            throw new ProductException(ProductErrorCode.INFO_PATTERN_MUST_BE_VALID);
        }
    }

    private static boolean isNotValid(String value) {
        return !INFO_PATTERN.matcher(value).matches();
    }
}

