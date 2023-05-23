package com.multi.mariage.product.service;

import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.*;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.product.dto.response.ProductContentResponse;
import com.multi.mariage.product.dto.response.ProductFindResponse;
import com.multi.mariage.product.dto.response.ProductMainCardResponse;
import com.multi.mariage.product.dto.response.ProductReviewStatsResponse;
import com.multi.mariage.product.vo.ProductsVO;
import com.multi.mariage.review.vo.ReviewRateVO;
import com.multi.mariage.storage.domain.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductFindServiceTest extends ServiceTest {
    private Product 참이슬;
    private Image savedImage1;

    @BeforeEach
    void setUp() {
        Image image = new Image(ProductFixture.참이슬.getImageName());

        savedImage1 = storageRepository.save(image);
        ProductSaveRequest saveRequest = ProductFixture.참이슬.toProductSaveRequest(savedImage1.getId());
        참이슬 = productModifyService.save(saveRequest);
    }

    @DisplayName("제품을 조회한다.")
    @Test
    void 제품을_조회한다() {
        ProductFindResponse response = productFindService.findProducts();

        assertThat(response).isNotNull();
        List<ProductsVO> vo = response.getProduct();

        for (ProductsVO actual : vo) {
            assertThat(actual.getId()).isNotNull();
            assertThat(actual.getName()).isNotEmpty();
        }
    }

    @DisplayName("상세페이지의 제품 정보를 조회한다.")
    @Test
    void 상세페이지의_제품_정보를_조회한다() {
        Image image = new Image(ProductFixture.산토리_위스키.getImageName());
        Image 산토리_위스키_이미지 = storageRepository.save(image);
        Product 산토리_위스키 = saveProduct(ProductFixture.산토리_위스키, 산토리_위스키_이미지.getId());
        Long productId = 산토리_위스키.getId();
        ProductContentResponse response = productFindService.findProductContent(productId);
        assertThat(response).isNotNull();
    }

    @DisplayName("전체기간_동안_가장_많은_리뷰가_달린_제품들을_추천한다")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void 전체기간_동안_가장_많은_리뷰가_달린_제품들을_추천한다(int size) {
        // given
        Member member = signup(MemberFixture.MARI);
        Image savedImage2 = storageRepository.save(new Image(ProductFixture.산토리_위스키.getImageName()));
        Product product = productModifyService.save(ProductFixture.산토리_위스키.toProductSaveRequest(savedImage2.getId()));
        saveReview(ReviewFixture.참이슬_과자, member.getId(), 참이슬.getId(), savedImage1.getId());
        saveReview(ReviewFixture.산토리위스키_해산물, member.getId(), product.getId(), savedImage2.getId());

        // when
        List<ProductMainCardResponse> actual = productFindService.findTotal(size);

        // then
        assertThat(actual).hasSize(size);
    }

    @DisplayName("전체기간 동안 가장 많은 리뷰가 달린 제품만 추천한다.")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void 전체기간_동안_가장_많은_리뷰가_달린_제품만_추천한다(int size) {
        // given
        Member member = signup(MemberFixture.MARI);
        Image savedImage2 = storageRepository.save(new Image(ImageFixture.JPEG_IMAGE.getOriginFileName()));
        saveReview(ReviewFixture.참이슬_과자, member.getId(), 참이슬.getId(), savedImage1.getId());
        saveReview(ReviewFixture.참이슬_치킨, member.getId(), 참이슬.getId(), savedImage2.getId());

        // when
        List<ProductMainCardResponse> actual = productFindService.findTotal(size);

        // then
        assertThat(actual).hasSize(1);
    }

    @DisplayName("일주일 동안 가장 많은 리뷰가 달린 제품을 추천한다.")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void 일주일_동안_가장_많은_리뷰가_달린_제품을_추천한다(int size) {
        /* given */
        Member member = signup(MemberFixture.MARI);
        saveReview(ReviewFixture.참이슬_과자, member.getId(), 참이슬.getId(), savedImage1.getId());

        Image savedImage2 = storageRepository.save(new Image(ProductFixture.산토리_위스키.getImageName()));
        Product product = productModifyService.save(ProductFixture.산토리_위스키.toProductSaveRequest(savedImage2.getId()));
        reviewRepository.save(ReviewFixture.산토리위스키_해산물.toReview(member, product,
                savedImage2, weatherRepository.save(WeatherFixture.맑음_2주전.toWeather())));

        /* when */
        List<ProductMainCardResponse> actual = productFindService.findWeek(size);

        /* then */
        assertThat(actual).hasSize(1);
    }

    @DisplayName("한달 동안 가장 많은 리뷰가 달린 제품을 추천한다.")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void 한달_동안_가장_많은_리뷰가_달린_제품을_추천한다(int size) {
        /* given */
        Member member = signup(MemberFixture.MARI);
        saveReview(ReviewFixture.참이슬_과자, member.getId(), 참이슬.getId(), savedImage1.getId());

        Image savedImage2 = storageRepository.save(new Image(ProductFixture.산토리_위스키.getImageName()));
        Product product = productModifyService.save(ProductFixture.산토리_위스키.toProductSaveRequest(savedImage2.getId()));
        reviewRepository.save(ReviewFixture.산토리위스키_해산물.toReview(member, product,
                savedImage2, weatherRepository.save(WeatherFixture.맑음_2달전.toWeather())));

        /* when */
        List<ProductMainCardResponse> actual = productFindService.findMonth(size);

        /* then */
        assertThat(actual).hasSize(1);
    }

    @DisplayName("상세페이지의 제품에 대한 리뷰 별점 통계 정보를 조회한다.")
    @Test
    void 상세페이지의_제품에_대한_리뷰_별점_통계_정보를_조회한다() {
        Image image = new Image(ProductFixture.산토리_위스키.getImageName());
        Image 산토리_위스키_이미지 = storageRepository.save(image);
        Product 산토리_위스키 = saveProduct(ProductFixture.산토리_위스키, 산토리_위스키_이미지.getId());
        Long productId = 산토리_위스키.getId();

        ProductReviewStatsResponse response = productFindService.findProductReviewStats(productId);
        assertThat(response).isNotNull();

        List<ReviewRateVO> vo = response.getPercentageList();

        for (ReviewRateVO actual : vo) {
            assertThat(actual.getPercentage()).isNotNull();
            assertThat(actual.getReviewRate()).isNotNull();
        }
    }
}
