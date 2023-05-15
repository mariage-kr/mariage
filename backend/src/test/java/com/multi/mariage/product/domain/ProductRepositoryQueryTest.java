package com.multi.mariage.product.domain;


import com.multi.mariage.common.annotation.RepositoryTest;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.repository.StorageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProductRepositoryQueryTest extends RepositoryTest {
    private Product 참이슬;
    private Product 처음처럼;
    private Product 간바레오또상;
    private Product 일품진로;
    private Product 산토리_위스키;

    @BeforeEach
    void setUp() {
        참이슬 = saveProduct(ProductFixture.참이슬);
        처음처럼 = saveProduct(ProductFixture.처음처럼);
        간바레오또상 = saveProduct(ProductFixture.간바레오또상);
        일품진로 = saveProduct(ProductFixture.일품진로);
        산토리_위스키 = saveProduct(ProductFixture.산토리_위스키);
    }

    @DisplayName("제품을 검색한다.")
    @Test
    void 제품을_검색한다() {
        List<Product> actual = productRepository.searchProductByName("진로");

        assertThat(actual).contains(일품진로);
    }
}