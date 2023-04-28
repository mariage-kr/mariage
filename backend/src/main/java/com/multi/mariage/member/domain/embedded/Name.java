package com.multi.mariage.member.domain.embedded;

import com.multi.mariage.member.exception.MemberErrorCode;
import com.multi.mariage.member.exception.MemberException;
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
    private static final String NAME_FORMAT = "^([가-힣]{2,30})$";
    private static final Pattern NAME_PATTERN = Pattern.compile(NAME_FORMAT);
    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 30;

    @Column(name = "name", nullable = false)
    private String value;

    private Name(String value) {
        this.value = value;
    }

    public static Name of(String value) {
        validateLengthInRange(value);
        validatePatternIsValid(value);
        return new Name(value);
    }

    private static void validatePatternIsValid(String value) {
        if (isNotValid(value)) {
            throw new MemberException(MemberErrorCode.NAME_PATTERN_MUST_BE_VALID);
        }
    }

    private static boolean isNotValid(String value) {
        return !NAME_PATTERN.matcher(value).matches();
    }

    private static void validateLengthInRange(String value) {
        int length = value.length();
        if (length < MIN_LENGTH || MAX_LENGTH < length) {
            throw new MemberException(MemberErrorCode.NAME_CANNOT_BE_OUT_OF_RANGE);
        }
    }
}
