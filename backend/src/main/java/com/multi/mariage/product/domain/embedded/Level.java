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
    private static final String LEVEL_FORMAT = "^\\d+(\\.\\d{1,3})?$";   // 소수점 셋째자리까지 허용.
    private static final Pattern LEVEL_PATTERN = Pattern.compile(LEVEL_FORMAT);
    private static final double MIN_VALUE = 0.001;
    private static final double MAX_VALUE = 100;
    @Column(name = "level", nullable = false)
    private double value;

    private Level(double value) {
        this.value = value;
    }

    public static Level of(double value) {
        validateValueInRange(value);
        validatePatternIsValid(value);
        return new Level(value);
    }

    private static void validateValueInRange(double value) {

        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new ProductException(ProductErrorCode.LEVEL_CANNOT_BE_OUT_OF_RANGE);
        }
    }

    private static void validatePatternIsValid(double value) {
        if (isNotValid(value)) {
            throw new ProductException(ProductErrorCode.LEVEL_PATTERN_MUST_BE_VALID);
        }
    }

    private static boolean isNotValid(double value) {
        return !LEVEL_PATTERN.matcher(String.valueOf(value)).matches();
    }
}
