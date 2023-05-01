package com.multi.mariage.member.domain.embedded;

import com.multi.mariage.member.exception.MemberErrorCode;
import com.multi.mariage.member.exception.MemberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EmailTest {
    @DisplayName("유효한 이메일인 경우 객체를 생성한다.")
    @Test
    void 유효한_이메일인_경우_객체를_생성한다() {
        String email = "test1234@gmail.com";

        assertThatCode(() -> Email.of(email))
                .doesNotThrowAnyException();
    }

    @DisplayName("이메일 아이디는")
    @Nested
    class emailIdTest {
        @DisplayName("길이가 8자리 미만, 16자리 초과이면 예외를 던진다.")
        @ParameterizedTest
        @ValueSource(ints = {6, 16})    /* 7, 17 */
        void 이메일_아이디의_길이가_8자리_미만_16자리_초과이면_예외를_던진다(int size) {
            String email = "a".repeat(size) + "1@gmail.com";

            assertThatThrownBy(() -> Email.of(email))
                    .isInstanceOf(MemberException.class)
                    .hasMessageContaining(MemberErrorCode.EMAIL_PATTERN_MUST_BE_VALID.getMessage());
        }

        @DisplayName("숫자와 영어 소문자로 이루어지지 않으면 예외를 던진다.")
        @ParameterizedTest
        @ValueSource(strings = {"Test1234@gmail.com", "test1234!@gmail.com", "테스트12345@gmail.com"})
        void 이메일_아이디는_숫자와_영어_소문자로_이루어지지_않으면_예외를_던진다(String email) {
            assertThatThrownBy(() -> Email.of(email))
                    .isInstanceOf(MemberException.class)
                    .hasMessageContaining(MemberErrorCode.EMAIL_PATTERN_MUST_BE_VALID.getMessage());
        }
    }
}