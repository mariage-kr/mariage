package com.multi.mariage.product.domain.embedded;

import com.multi.mariage.member.domain.embedded.Email;
import com.multi.mariage.member.exception.MemberErrorCode;
import com.multi.mariage.member.exception.MemberException;
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
    private static final String NAME_FORMAT = "^([가-힣]{1,40})$";
    private static final Pattern NAME_PATTERN = Pattern.compile(NAME_FORMAT);
    @Column(name = "name", nullable = false, unique = true)
    private String value;


    private Name(String value) {
        this.value = value;
    }

    public static Name of(String value) {
        validatePatternIsValid(value);
        return new Name(value);
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

