package com.multi.mariage.product.service;

import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.repository.StorageRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class ProductServiceTest extends ServiceTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StorageRepository storageRepository;
    @Autowired
    private ProductService productService;

    @DisplayName("제품을 등록한다.")
    @Test
    void 제품을_등록한다() {
        Image image = storageRepository.save(new Image("test.jpg"));
        ProductSaveRequest request = ProductFixture.참이슬.toProductSaveRequest(image.getId());
        Product actual = productService.save(request);
        assertThat(actual).isNotNull();
    }

    @DisplayName("제품을 조회한다.")
    @Test
    void 제품을_조회한다() {
    }

}