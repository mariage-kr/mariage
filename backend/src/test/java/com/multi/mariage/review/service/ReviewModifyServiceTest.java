package com.multi.mariage.review.service;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.category.domain.Food;
import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.*;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.ReviewHashtag;
import com.multi.mariage.review.dto.request.ReviewUpdateRequest;
import com.multi.mariage.review.dto.response.ReviewSaveResponse;
import com.multi.mariage.weather.domain.Weather;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.mock.web.MockMultipartFile;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReviewModifyServiceTest extends ServiceTest {

    private Member member;
    private Long imageId;
    private Product product;
    private Review review;

    @BeforeEach
    void setUp() {
        member = signup(MemberFixture.MARI);
        imageId = saveImage(ImageFixture.JPEG_IMAGE).getImageId();
        product = saveProduct(ProductFixture.참이슬, imageId);

        saveReview(ReviewFixture.참이슬_과자, member.getId(), product.getId(), imageId);
    }

    @DisplayName("리뷰를 저장한다.")
    @Test
    void 리뷰를_저장한다() {
        ReviewSaveResponse actual = saveReview(ReviewFixture.참이슬_치킨, member.getId(), product.getId(), imageId);

        Assertions.assertThat(actual).isNotNull();
    }

    @DisplayName("리뷰의 제품 점수와 음식 정보를 수정한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5})
    void 리뷰의_제품_점수와_음식_정보를_수정한다(int productRate) {

        Food food = saveFood(ReviewFixture.참이슬_치킨, product);
        Long imageId = saveImage(ImageFixture.JPEG_IMAGE).getImageId();

        review = saveReviewInfo(ReviewFixture.참이슬_치킨, member.getId(), product.getId(), food.getId());
        MockMultipartFile newImageFile = ImageFixture.JPEG_IMAGE2.toMultipartFile();
        List<String> hashTags = ReviewFixture.참이슬_치킨.getHashtags();

        ReviewUpdateRequest request = ReviewUpdateRequest.builder()
                .id(review.getId())
                .productId(product.getId())
                .productRate(productRate)
                .content(review.getContent())
                .foodRate(review.getFoodRate())
                .foodCategory(food.getCategory())
                .foodImageId(imageId)
                .file(newImageFile)
                .hashtags(hashTags)
                .build();

        reviewModifyService.update(new AuthMember(member.getId()), request);

        Review actual = reviewFindService.findById(review.getId());
        assertThat(actual.getProductRate()).isEqualTo(productRate);
    }
}