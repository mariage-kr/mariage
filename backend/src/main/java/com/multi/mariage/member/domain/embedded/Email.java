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
public class Email {

    private static final String EMAIL_FORMAT = "^[a-z0-9._-]{8,16}+@[a-z]+[.]+[a-z]{2,3}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_FORMAT);
    @Column(name = "email", nullable = false, unique = true)
    private String value;


    private Email(String value) {
        this.value = value;
    }

    public static Email of(String value) {
        validatePatternIsValid(value);
        return new Email(value);
    }

    private static void validatePatternIsValid(String value) {
        if (isNotValid(value)) {
            throw new MemberException(MemberErrorCode.EMAIL_PATTERN_MUST_BE_VALID);
        }
    }

    private static boolean isNotValid(String value) {
        return !EMAIL_PATTERN.matcher(value).matches();
    }
}
