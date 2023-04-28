package com.multi.mariage.member.domain.embedded;

import com.multi.mariage.member.exception.MemberErrorCode;
import com.multi.mariage.member.exception.MemberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("유효한 이름인 경우 객체를 생성한다.")
    @Test
    void 유효한_이름인_경우_객체를_생성한다() {
        String name = "마리";

        assertThatCode(() -> Name.of(name))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름의 길이가 2자리 미만 30자리 초과이면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 31})
    void 이름의_길이가_2자리_미만_30자리_초과이면_예외를_던진다(int size) {
        String name = "가".repeat(size);

        assertThatThrownBy(() -> Name.of(name))
                .isInstanceOf(MemberException.class)
                .hasMessageContaining(MemberErrorCode.NAME_CANNOT_BE_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("한글로 이루어지지 않으면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"mari", "마리12", "마리!@", "ㅁㄹ"})
    void 한글로_이루어지지_않으면_예외를_던진다(String name) {
        assertThatThrownBy(() -> Name.of(name))
                .isInstanceOf(MemberException.class)
                .hasMessageContaining(MemberErrorCode.NAME_PATTERN_MUST_BE_VALID.getMessage());
    }
}