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
public class Nickname {
    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 12;
    private static final String NICKNAME_FORMAT = "^([가-힣a-zA-Z0-9]+)$";
    private static final Pattern NICKNAME_PATTERN = Pattern.compile(NICKNAME_FORMAT);

    @Column(name = "nickname", nullable = false)
    private String value;

    private Nickname(String value) {
        validateLengthInRange(value);
        validatePatternIsValid(value);
        this.value = value;
    }

    public static Nickname of(String value) {
        return new Nickname(value);
    }

    private static void validateLengthInRange(String value) {
        int length = value.length();
        if (length < MIN_LENGTH || MAX_LENGTH < length) {
            throw new MemberException(MemberErrorCode.NICKNAME_CANNOT_BE_OUT_OF_RANGE);
        }
    }

    private static void validatePatternIsValid(String value) {
        if (isNotValid(value)) {
            throw new MemberException(MemberErrorCode.NICKNAME_PATTERN_MUST_BE_VALID);
        }
    }

    private static boolean isNotValid(String value) {
        return !NICKNAME_PATTERN.matcher(value).matches();
    }
}
