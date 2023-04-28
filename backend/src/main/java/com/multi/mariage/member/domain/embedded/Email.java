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

    private static final int PREFIX_MIN_LENGTH = 8;
    private static final int PREFIX_MAX_LENGTH = 16;
    private static final int DOMAIN_MIN_LENGTH = 2;
    private static final int DOMAIN_MAX_LENGTH = 63;

    private static final String EMAIL_FORMAT = "^[a-z0-9._-]+@[a-z]+[.]+[a-z]{2,3}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_FORMAT);
    @Column(name = "email", nullable = false, unique = true)
    private String value;


    private Email(String value) {
        this.value = value;
    }

    public static Email of(String value) {
        validateLengthInRangeByPrefix(value);
        validateLengthInRangeByDomain(value);
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

    private static void validateLengthInRangeByPrefix(String value) {
        int prefixLength = value.substring(0, value.indexOf("@")).length();
        if (prefixLength < PREFIX_MIN_LENGTH || PREFIX_MAX_LENGTH < prefixLength) {
            throw new MemberException(MemberErrorCode.EMAIL_ID_CANNOT_BE_OUT_OF_RANGE);
        }
    }

    private static void validateLengthInRangeByDomain(String value) {
        int domainLength = value.substring(value.indexOf("@") + 1, value.indexOf(".")).length();
        if (domainLength < DOMAIN_MIN_LENGTH || DOMAIN_MAX_LENGTH < domainLength) {
            throw new MemberException(MemberErrorCode.EMAIL_DOMAIN_NAME_CANNOT_BE_OUT_OF_RANGE);
        }
    }
}
