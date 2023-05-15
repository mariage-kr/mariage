package com.multi.mariage.product.domain;

import com.multi.mariage.common.annotation.RepositoryTest;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.repository.StorageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductRepositoryTest extends RepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StorageRepository storageRepository;

    private Product 참이슬;
    private Product 처음처럼;
    private Product 간바레오또상;
    private Product 일품진로;

    @BeforeEach
    void setUp() {
        참이슬 = saveProduct(ProductFixture.참이슬);
        처음처럼 = saveProduct(ProductFixture.처음처럼);
        간바레오또상 = saveProduct(ProductFixture.간바레오또상);
        일품진로 = saveProduct(ProductFixture.일품진로);
    }

    @DisplayName("제품을 저장한다.")
    @Test
    void 제품을_저장한다() {
        Product actual = saveProduct(ProductFixture.산토리_위스키);
        assertThat(actual).isNotNull();
    }

    private Product saveProduct(ProductFixture productFixture) {
        Product product = productFixture.toProduct();

        Image image = storageRepository.save(new Image(productFixture.getImageName()));
        product.setImage(image);

        return productRepository.save(product);
    }
}
