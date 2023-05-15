package com.multi.mariage.product.domain.embedded;

import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
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
        String name = "호가든";

        assertThatCode(() -> com.multi.mariage.product.domain.embedded.Name.of(name))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름의 길이가 1자리 미만 40자리 초과이면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 41})
    void 이름의_길이가_1자리_미만_40자리_초과이면_예외를_던진다(int size) {
        String name = "가".repeat(size);

        assertThatThrownBy(() -> com.multi.mariage.product.domain.embedded.Name.of(name))
                .isInstanceOf(ProductException.class)
                .hasMessageContaining(ProductErrorCode.NAME_CANNOT_BE_OUT_OF_RANGE.getMessage());
    }
}