package com.multi.mariage.product.service;

import com.multi.mariage.category.dto.response.FoodCategoryResponse;
import com.multi.mariage.category.vo.food.FoodCategoriesVO;
import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.member.dto.request.MemberSignupRequest;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.product.dto.response.ProductFindResponse;
import com.multi.mariage.product.vo.ProductsVO;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.repository.StorageRepository;
import com.multi.mariage.storage.service.ImageService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

        ProductSaveRequest request = ProductFixture.PRODUCT_MAKGEOLLI.toRegisterRequest();
        Image savedImage = storageRepository.save(new Image("test.jpg"));
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
    
}