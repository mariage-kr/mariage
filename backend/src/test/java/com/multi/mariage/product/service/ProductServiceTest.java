package com.multi.mariage.product.service;

import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.product.dto.request.ProductUpdateRequest;
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
    private ProductRepository productRepository;
    @Autowired
    private StorageRepository storageRepository;
    @Autowired
    private ProductService productService;
    private Product product;

    @BeforeEach
    void setUp() {
        ProductSaveRequest saveRequest = ProductFixture.PRODUCT_MAKGEOLLI1.toSaveRequest();

        Image savedImage = storageRepository.save(new Image("test.jpg"));
        Long imageId = savedImage.getId();

        saveRequest.setImageId(imageId);

        product = productService.save(saveRequest);
    }

    @DisplayName("제품을 등록한다.")
    @Test
    void 제품을_등록한다() {

        ProductSaveRequest request = ProductFixture.PRODUCT_SOJU1.toSaveRequest();
        Image savedImage = storageRepository.save(new Image("test1.jpg"));
        Long imageId = savedImage.getId();

        request.setImageId(imageId);

        Product actual = productService.save(request);
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

    @DisplayName("제품을 수정한다.")
    @Test
    void 제품을_수정한다() {
        Image savedNewImage = storageRepository.save(new Image("test2.jpg"));
        Long newImageId = savedNewImage.getId();

        Long imageId = product.getImage().getId();
        ProductUpdateRequest request = ProductFixture.PRODUCT_SOJU1.toUpdateRequest(product, imageId, newImageId);
        request.setImageId(imageId);

        productService.update(request);
        assertThat(request).isNotNull();

    }

}