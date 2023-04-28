package com.multi.mariage.member.domain.embedded;

import com.multi.mariage.member.exception.MemberErrorCode;
import com.multi.mariage.member.exception.MemberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PasswordTest {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @DisplayName("유효한 비밀번호인 경우 암호화 한다.")
    @Test
    void 유효한_비밀번호인_경우_암호화_한다() {
        String password = "test1234!@";

        assertThatCode(() -> Password.encrypt(password, passwordEncoder))
                .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호 길이는 8자 미만, 16자 초과인 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {7, 17})
    void 비밀번호_길이는_8자_미만_16자_초과인_경우_예외를_던진다(int size) {
        String password = "a".repeat(size);

        assertThatThrownBy(() -> Password.encrypt(password, passwordEncoder))
                .isInstanceOf(MemberException.class)
                .hasMessageContaining(MemberErrorCode.PASSWORD_CANNOT_BE_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("비밀번호는 영문자와 숫자, 특수문자로 이루어지며 숫자와 특수문자가 없으면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"test1234", "test!@!@", "1234!@!@"})
    void 비빌번호는_영문자와_숫자_특수문자로_이루어지며_숫자와_특수문자가_없으면_예외를_던진다(String password) {
        assertThatThrownBy(() -> Password.encrypt(password, passwordEncoder))
                .isInstanceOf(MemberException.class)
                .hasMessageContaining(MemberErrorCode.PASSWORD_PATTERN_MUST_BE_VALID.getMessage());
    }
}