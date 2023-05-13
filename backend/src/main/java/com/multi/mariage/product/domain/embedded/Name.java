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
public class Name {
    private static final String NAME_FORMAT = "^.{1,40}$";
    private static final Pattern NAME_PATTERN = Pattern.compile(NAME_FORMAT);
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 40;
    @Column(name = "name", nullable = false, unique = true)
    private String value;


    private Name(String value) {
        this.value = value;
    }

    public static Name of(String value) {
        validateLengthInRange(value);
        validatePatternIsValid(value);
        return new Name(value);
    }

    private static void validateLengthInRange(String value) {
        int length = value.length();
        if (length < MIN_LENGTH || MAX_LENGTH < length) {
            throw new ProductException(ProductErrorCode.NAME_CANNOT_BE_OUT_OF_RANGE);
        }
    }

    private static void validatePatternIsValid(String value) {
        if (isNotValid(value)) {
            throw new ProductException(ProductErrorCode.NAME_PATTERN_MUST_BE_VALID);
        }
    }

    private static boolean isNotValid(String value) {
        return !NAME_PATTERN.matcher(value).matches();
    }
}

