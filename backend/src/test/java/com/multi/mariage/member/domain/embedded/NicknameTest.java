package com.multi.mariage.member.domain.embedded;

import com.multi.mariage.member.exception.MemberErrorCode;
import com.multi.mariage.member.exception.MemberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NicknameTest {

    @DisplayName("유효한 별칭인 경우 객체를 생성한다.")
    @Test
    void 유효한_별칭인_경우_객체를_생성한다() {
        String nickname = "마리";

        assertThatCode(() -> Nickname.of(nickname))
                .doesNotThrowAnyException();
    }

    @DisplayName("별칭의 길이가 2자리 미만 12자리 초과이면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 13})
    void 별칭의_길이가_2자리_미만_12자리_초과이면_예외를_던진다(int size) {
        String nickname = "a".repeat(size);

        assertThatThrownBy(() -> Nickname.of(nickname))
                .isInstanceOf(MemberException.class)
                .hasMessageContaining(MemberErrorCode.NICKNAME_CANNOT_BE_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("별칭은 한글, 영문자, 숫자로 이루어지지 않으면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"!@", "ㅁ리"})
    void 별칭은_한글_영문자_숫자로_이루어지지_않으면_예외를_던진다(String nickname) {
        assertThatThrownBy(() -> Nickname.of(nickname))
                .isInstanceOf(MemberException.class)
                .hasMessageContaining(MemberErrorCode.NICKNAME_PATTERN_MUST_BE_VALID.getMessage());
    }
}