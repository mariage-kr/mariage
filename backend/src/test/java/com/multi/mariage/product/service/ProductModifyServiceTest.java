package com.multi.mariage.product.service;

import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.product.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductModifyServiceTest extends ServiceTest {

    private Product product;

    @BeforeEach
    void setUp() {
        Long imageId = saveImage(ImageFixture.JPEG_IMAGE).getImageId();

        product = saveProduct(ProductFixture.참이슬, imageId);
    }

    @DisplayName("제품을 등록한다.")
    @Test
    void 제품을_등록한다() {
        Long imageId = saveImage(ImageFixture.JPEG_IMAGE2).getImageId();

        Product actual = saveProduct(ProductFixture.일품진로, imageId);

        assertThat(actual).isNotNull();
    }
}
