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
public class Level {
    private static final String LEVEL_FORMAT = "^([1-9]?\\d(\\.\\d{1,3})?|0(\\.\\d{1,3})?|100(\\.0{1,3})?)$";   // 소수점 셋째자리까지 허용. 0.001 ~ 100 범위
    private static final Pattern LEVEL_PATTERN = Pattern.compile(LEVEL_FORMAT);
    @Column(name = "level", nullable = false)
    private String value;

    private Level(String value) {
        this.value = value;
    }

    public static Level of(String value) {
        validatePatternIsValid(value);
        return new Level(value);
    }

    private static void validatePatternIsValid(String value) {
        if (isNotValid(value)) {
            throw new ProductException(ProductErrorCode.LEVEL_PATTERN_MUST_BE_VALID);
        }
    }

    private static boolean isNotValid(String value) {
        return !LEVEL_PATTERN.matcher(value).matches();
    }
}
