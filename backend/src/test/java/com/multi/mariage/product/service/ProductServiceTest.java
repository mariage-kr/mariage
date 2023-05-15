package com.multi.mariage.product.service;

import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.product.dto.response.ProductFindResponse;
import com.multi.mariage.product.vo.ProductsVO;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.repository.StorageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductServiceTest extends ServiceTest {
    @Autowired
    private StorageRepository storageRepository;
    @Autowired
    private ProductService productService;
    private Product registeredProduct;

    @BeforeEach
    void setUp() {
        Image savedImage = storageRepository.save(new Image(ProductFixture.참이슬.getImageName()));
        ProductSaveRequest saveRequest = ProductFixture.참이슬.toProductSaveRequest(savedImage.getId());

        registeredProduct = productService.save(saveRequest);
    }

    @DisplayName("제품을 등록한다.")
    @Test
    void 제품을_등록한다() {
        Image savedImage = storageRepository.save(new Image(ProductFixture.간바레오또상.getImageName()));
        ProductSaveRequest saveRequest = ProductFixture.간바레오또상.toProductSaveRequest(savedImage.getId());

        Product actual = productService.save(saveRequest);

        assertThat(actual).isNotNull();
    }

    @DisplayName("제품을 조회한다.")
    @Test
    void 제품을_조회한다() {
        ProductFindResponse response = productService.findProducts();

        assertThat(response).isNotNull();
        List<ProductsVO> vo = response.getProduct();

        for (ProductsVO actual : vo) {
            assertThat(actual.getId()).isNotNull();
            assertThat(actual.getName()).isNotEmpty();
        }
    }

}