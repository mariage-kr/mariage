package com.multi.mariage.product.domain.embedded;

import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InfoTest {

    @DisplayName("유효한 정보인 경우 객체를 생성한다.")
    @Test
    void 유효한_정보인_경우_객체를_생성한다() {
        String info = "호가든은 밀, 코리엔더 씨드, 오렌지 필을 사용해 매혹적이고 은은한 향이 특징이며 특유의 부드럽고 풍성한 맛과 구름거품이 특징인 맥주입니다.";

        assertThatCode(() -> com.multi.mariage.product.domain.embedded.Info.of(info))
                .doesNotThrowAnyException();
    }

    @DisplayName("정보의 길이가 1자리 미만 255자리 초과이면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 256})
    void 정보의_길이가_1자리_미만_255자리_초과이면_예외를_던진다(int size) {
        String info = "가".repeat(size);

        assertThatThrownBy(() -> com.multi.mariage.product.domain.embedded.Info.of(info))
                .isInstanceOf(ProductException.class)
                .hasMessageContaining(ProductErrorCode.INFO_CANNOT_BE_OUT_OF_RANGE.getMessage());
    }
}