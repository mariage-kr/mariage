package com.multi.mariage.product.service;

import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.service.ImageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.parameters.P;

import static org.assertj.core.api.Assertions.assertThat;

class ProductModifyServiceTest extends ServiceTest {
    @BeforeEach
    void setUp() {
        Image image = new Image(ProductFixture.참이슬.getImageName());

        Image savedImage = storageRepository.save(image);
        ProductSaveRequest saveRequest = ProductFixture.참이슬.toProductSaveRequest(savedImage.getId());

        productModifyService.save(saveRequest);
    }

    @DisplayName("제품을 등록한다.")
    @Test
    void 제품을_등록한다() {
        Image savedImage = storageRepository.save(new Image(ProductFixture.간바레오또상.getImageName()));
        ProductSaveRequest saveRequest = ProductFixture.간바레오또상.toProductSaveRequest(savedImage.getId());

        Product actual = productModifyService.save(saveRequest);

        assertThat(actual).isNotNull();
    }

    @DisplayName("식별자를 통해 제품을 삭제한다.")
    @Test
    void 식별자를_통해_제품을_삭제한다() {
        Product product = save();

        productModifyService.remove(product.getId());

    }

    private Product save() {
        Image savedImage = storageRepository.save(new Image(ProductFixture.처음처럼.getImageName()));
        ProductSaveRequest saveRequest = ProductFixture.처음처럼.toProductSaveRequest(savedImage.getId());

        Product actual = productModifyService.save(saveRequest);
        return actual;
    }
}
