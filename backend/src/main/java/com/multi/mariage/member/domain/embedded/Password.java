package com.multi.mariage.member.domain.embedded;

import com.multi.mariage.member.exception.MemberErrorCode;
import com.multi.mariage.member.exception.MemberException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.regex.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Password {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 16;
    private static final String PASSWORD_FORMAT =
            "^(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_FORMAT);
    @Column(name = "password", nullable = false)
    private String value;

    private Password(String value) {
        this.value = value;
    }

    public static Password encrypt(String value, PasswordEncoder passwordEncoder) {
        validateLengthInRange(value);
        validatePatternIsValid(value);
        return new Password(passwordEncoder.encode(value));
    }

    private static void validateLengthInRange(String value) {
        int length = value.length();
        if (length < MIN_LENGTH || MAX_LENGTH < length) {
            throw new MemberException(MemberErrorCode.PASSWORD_CANNOT_BE_OUT_OF_RANGE);
        }

    }

    private static void validatePatternIsValid(String value) {
        if (isNotValid(value)) {
            throw new MemberException(MemberErrorCode.PASSWORD_PATTERN_MUST_BE_VALID);
        }
    }

    private static boolean isNotValid(String value) {
        return !PASSWORD_PATTERN.matcher(value).matches();
    }
}
