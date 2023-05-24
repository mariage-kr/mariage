package com.multi.mariage.product.domain;

import com.multi.mariage.common.annotation.RepositoryTest;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.product.domain.embedded.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductRepositoryTest extends RepositoryTest {

    private Product 참이슬;

    @BeforeEach
    void setUp() {
        참이슬 = saveProduct(ProductFixture.참이슬);
    }

    @DisplayName("제품을 저장한다.")
    @Test
    void 제품을_저장한다() {
        Product actual = saveProduct(ProductFixture.산토리_위스키);
        assertThat(actual).isNotNull();
    }

    @DisplayName("제품이름이 존재하는지 조회한다.")
    @Test
    void 제품이름이_존재하는지_조회한다() {
        Name name = Name.of(참이슬.getName());

        boolean actual = productRepository.existsByName(name);

        assertThat(actual).isTrue();
    }
}
