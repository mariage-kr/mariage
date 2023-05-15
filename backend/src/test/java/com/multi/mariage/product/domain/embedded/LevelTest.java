package com.multi.mariage.product.domain.embedded;

import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LevelTest {

    @DisplayName("유효한 도수인 경우 객체를 생성한다.")
    @Test
    void 유효한_도수인_경우_객체를_생성한다() {
        double level = 20;

        assertThatCode(() -> Level.of(level))
                .doesNotThrowAnyException();
    }

    @DisplayName("도수의 값이 0 미만 100 초과이면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(doubles = {0.0001, 100.1, 100.001})
    void 도수의_값이_0_미만_100_초과이면_예외를_던진다(double value) {
        assertThatThrownBy(() -> Level.of(value))
                .isInstanceOf(ProductException.class)
                .hasMessageContaining(ProductErrorCode.LEVEL_CANNOT_BE_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("도수의 소수점이 3개 초과이면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(doubles = {0.1111, 89.9999})
    void 도수의_소수점이_3개_초과이면_예외를_던진다(double value) {
        assertThatThrownBy(() -> Level.of(value))
                .isInstanceOf(ProductException.class)
                .hasMessageContaining(ProductErrorCode.LEVEL_PATTERN_MUST_BE_VALID.getMessage());
    }
}