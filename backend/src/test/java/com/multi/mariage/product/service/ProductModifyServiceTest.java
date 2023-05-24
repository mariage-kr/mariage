package com.multi.mariage.product.service;

import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.product.dto.request.ProductUpdateRequest;
import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ProductModifyServiceTest extends ServiceTest {

    private Product product;
    private Long imageId;

    @BeforeEach
    void setUp() {
        imageId = saveImage(ImageFixture.JPEG_IMAGE).getImageId();

        product = saveProduct(ProductFixture.참이슬, imageId);
    }

    @DisplayName("제품을 등록한다.")
    @Test
    void 제품을_등록한다() {
        Long imageId = saveImage(ImageFixture.JPEG_IMAGE2).getImageId();

        Product actual = saveProduct(ProductFixture.일품진로, imageId);

        assertThat(actual).isNotNull();
    }

    @DisplayName("제품 이름이 중복되면 예외를 던진다.")
    @Test
    void 제품_이름이_중복되면_예외를_던진다() {
        Long imageId = saveImage(ImageFixture.JPEG_IMAGE2).getImageId();
        ProductSaveRequest request = ProductFixture.참이슬.toProductSaveRequest(imageId);

        assertThatThrownBy(() -> productModifyService.save(request))
                .isInstanceOf(ProductException.class)
                .hasMessageContaining(ProductErrorCode.SAVE_INVALID_PRODUCT.getMessage());
    }

    @DisplayName("제품을 수정한다.")
    @ParameterizedTest
    @ValueSource(strings = {"참이슬 후레쉬", "자몽 이슬"})
    void 제품을_수정한다(String name) {
        Long newImageId = saveImage(ImageFixture.JPEG_IMAGE2).getImageId();
        ProductUpdateRequest request = ProductUpdateRequest.builder()
                .id(product.getId())
                .name(name)
                .info(product.getInfo())
                .level(product.getLevel())
                .country(product.getCountry())
                .upperCategory(product.getUpperCategory())
                .lowerCategory(product.getLowerCategory())
                .imageId(imageId)
                .newImageId(newImageId)
                .build();

        productModifyService.update(request);

        Product actual = productFindService.findById(product.getId());
        assertThat(actual.getName()).isEqualTo(name);
    }
}
