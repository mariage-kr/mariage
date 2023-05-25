package com.multi.mariage.product.service;

import com.multi.mariage.category.domain.Food;
import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.*;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.product.dto.request.ProductFindByFilterRequest;
import com.multi.mariage.product.dto.response.*;
import com.multi.mariage.product.dto.response.temp.ProductContentResponse;
import com.multi.mariage.product.dto.response.temp.ProductReviewStatsResponse;
import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
import com.multi.mariage.product.vo.ProductDetailVO;
import com.multi.mariage.product.vo.ReviewRateVO;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.weather.domain.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class ProductFindServiceTest extends ServiceTest {
    private Product 참이슬;
    private Image savedImage;

    @BeforeEach
    void setUp() {
        savedImage = storageRepository.save(new Image(ProductFixture.참이슬.getImageName()));
        참이슬 = productModifyService.save(ProductFixture.참이슬.toProductSaveRequest(savedImage.getId()));
    }

    @DisplayName("제품 식별 번호로 찾는다.")
    @Test
    void 제품_식별_번호로_찾는다() {
        Product actual = productFindService.findById(참이슬.getId());

        assertThat(actual).isEqualTo(참이슬);
    }

    @DisplayName("제품이 존재하지 않으면 에외를 던진다.")
    @Test
    void 제품이_존재하지_않으면_예외를_던진다() {
        assertThatThrownBy(() -> productFindService.findById(-1L))
                .isInstanceOf(ProductException.class)
                .hasMessageContaining(ProductErrorCode.PRODUCT_IS_NOT_EXIST.getMessage());
    }

    @DisplayName("제품을 조회한다.")
    @Test
    void 제품을_조회한다() {
        ProductFindResponse response = productFindService.findProducts();

        assertThat(response).isNotNull();
        List<ProductDetailVO> vo = response.getProduct();

        for (ProductDetailVO actual : vo) {
            assertThat(actual.getId()).isNotNull();
            assertThat(actual.getName()).isNotEmpty();
        }
    }

    @DisplayName("제품의 정보를 조회한다")
    @Test
    void 제품의_정보를_조회한다() {
        ProductInfoResponse actual = productFindService.findProductInfo(참이슬.getId());

        assertAll(
                () -> assertThat(actual.getName()).isEqualTo(참이슬.getName()),
                () -> assertThat(actual.getInfo()).isEqualTo(참이슬.getInfo()),
                () -> assertThat(actual.getLevel()).isEqualTo(참이슬.getLevel()),
                () -> assertThat(actual.getCountry()).isEqualTo(참이슬.getCountry()),
                () -> assertThat(actual.getUpperCategory()).isEqualTo(참이슬.getUpperCategory()),
                () -> assertThat(actual.getLowerCategory()).isEqualTo(참이슬.getLowerCategory())
        );
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
        saveReview(ReviewFixture.참이슬_과자, member.getId(), 참이슬.getId(), savedImage.getId());
        saveReview(ReviewFixture.산토리위스키_해산물, member.getId(), product.getId(), savedImage2.getId());

        // when
        List<ProductMainCardResponse> actual = productFindService.findRecommendDate(size, "total");

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
        saveReview(ReviewFixture.참이슬_과자, member.getId(), 참이슬.getId(), savedImage.getId());
        saveReview(ReviewFixture.참이슬_치킨, member.getId(), 참이슬.getId(), savedImage2.getId());

        // when
        List<ProductMainCardResponse> actual = productFindService.findRecommendDate(size, "total");

        // then
        assertThat(actual).hasSize(1);
    }

    @DisplayName("일주일 동안 가장 많은 리뷰가 달린 제품을 추천한다.")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void 일주일_동안_가장_많은_리뷰가_달린_제품을_추천한다(int size) {
        /* given */
        Member member = signup(MemberFixture.MARI);
        saveReview(ReviewFixture.참이슬_과자, member.getId(), 참이슬.getId(), savedImage.getId());

        Image savedImage2 = storageRepository.save(new Image(ProductFixture.산토리_위스키.getImageName()));
        Product product = productModifyService.save(ProductFixture.산토리_위스키.toProductSaveRequest(savedImage2.getId()));
        reviewRepository.save(ReviewFixture.산토리위스키_해산물.toReview(member, product, savedImage2, weatherRepository.save(WeatherFixture.맑음_2주전.toWeather())));

        /* when */
        List<ProductMainCardResponse> actual = productFindService.findRecommendDate(size, "week");

        /* then */
        assertThat(actual).hasSize(1);
    }

    @DisplayName("한달 동안 가장 많은 리뷰가 달린 제품을 추천한다.")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void 한달_동안_가장_많은_리뷰가_달린_제품을_추천한다(int size) {
        /* given */
        Member member = signup(MemberFixture.MARI);
        saveReview(ReviewFixture.참이슬_과자, member.getId(), 참이슬.getId(), savedImage.getId());

        Image savedImage2 = storageRepository.save(new Image(ProductFixture.산토리_위스키.getImageName()));
        Product product = productModifyService.save(ProductFixture.산토리_위스키.toProductSaveRequest(savedImage2.getId()));
        reviewRepository.save(ReviewFixture.산토리위스키_해산물.toReview(member, product,
                savedImage2, weatherRepository.save(WeatherFixture.맑음_2달전.toWeather())));

        /* when */
        List<ProductMainCardResponse> actual = productFindService.findRecommendDate(size, "month");

        /* then */
        assertThat(actual).hasSize(1);
    }

    @DisplayName("필터 조건으로 제품을 조회한다.")
    @Test
    void 필터_조건으로_제품을_조회한다() {
        saveReviews();

        ProductFindByFilterRequest cond = ProductFindByFilterRequest.builder()
                .pageNumber(1)
                .pageSize(2)
                .sort("count")
                .minRate(0)
                .maxRate(5)
                .minLevel(30)
                .maxLevel(70)
                .build();

        /* 산토리 위스키 */
        ProductFilterResponse actual = productFindService.findByFilter(cond);

        assertThat(actual.getTotalCount()).isEqualTo(1);
    }

    /* TODO: 2023/05/24 테이블 구조 변경으로 테스트 수정 고려 */
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

    @DisplayName("제품 상세페이지의 전체 정보를 조회한다.")
    @Test
    void 제품_상세페이지의_전체_정보를_조회한다() {
        Long productId = 참이슬.getId();

        ProductDetailPageResponse response = productFindService.findFullInfoByPage(productId);
        assertThat(response).isNotNull();
    }

    @DisplayName("제품의 리뷰 통계를 조회한다.")
    @Test
    void 제품의_리뷰_통계를_조회한다() {
        saveReviews();

        List<ReviewRateVO> reviewPercentages = productFindService.getReviewPercentages(참이슬.getId());

        for (ReviewRateVO reviewPercentage : reviewPercentages) {
            if (reviewPercentage.getReviewRate() == 4) {
                assertThat(reviewPercentage.getPercentage()).isEqualTo(50);
            }
            if (reviewPercentage.getReviewRate() == 3) {
                assertThat(reviewPercentage.getPercentage()).isEqualTo(50);
            }
        }
    }

    private void saveReviews() {
        Member member = signup(MemberFixture.MARI);

        Product 산토리_위스키 = saveProduct(ProductFixture.산토리_위스키, savedImage.getId());

        Weather 맑음 = saveWeather(WeatherFixture.맑음_현재);
        Weather 비 = saveWeather(WeatherFixture.비_현재);

        Food saveFood1 = saveFood(ReviewFixture.참이슬_치킨, 참이슬);
        Food saveFood2 = saveFood(ReviewFixture.참이슬_과자, 참이슬);
        Food saveFood3 = saveFood(ReviewFixture.산토리위스키_해산물, 산토리_위스키);

        saveReview(ReviewFixture.참이슬_치킨, member, 참이슬, saveFood1, savedImage, 맑음);
        saveReview(ReviewFixture.참이슬_과자, member, 참이슬, saveFood2, savedImage, 맑음);
        saveReview(ReviewFixture.산토리위스키_해산물, member, 산토리_위스키, saveFood3, savedImage, 비);
    }
}
