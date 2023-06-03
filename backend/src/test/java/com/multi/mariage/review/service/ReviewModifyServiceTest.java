package com.multi.mariage.review.service;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.category.domain.Food;
import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.common.fixture.ReviewFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.dto.request.ReviewUpdateRequest;
import com.multi.mariage.review.dto.response.ReviewSaveResponse;
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

        review = saveReviewInfo(ReviewFixture.참이슬_치킨, member.getId(), product.getId(), imageId);
        MockMultipartFile imageFile = ImageFixture.JPEG_IMAGE.toMultipartFile();
        List<String> hashTags = ReviewFixture.참이슬_치킨.getHashtags();

        ReviewUpdateRequest request = ReviewUpdateRequest.builder()
                .id(review.getId())
                .productId(product.getId())
                .productRate(productRate)
                .content(review.getContent())
                .foodRate(review.getFoodRate())
                .foodCategory(food.getCategory())
                .foodImageId(imageId)
                .hashtags(hashTags)
                .build();

        reviewModifyService.update(new AuthMember(member.getId()), request, imageFile);

        Review actual = reviewFindService.findById(review.getId());
        assertThat(actual.getProductRate()).isEqualTo(productRate);
        assertThat(actual.getFoodCategory().getCategory()).isEqualTo(FoodCategory.CHICKEN);
    }

    @DisplayName("리뷰의 이미지를 수정한다.")
    @Test
    void 리뷰의_이미지를_수정한다() {

        Long imageId = saveImage(ImageFixture.JPEG_IMAGE).getImageId();

        review = saveReviewInfo(ReviewFixture.참이슬_치킨, member.getId(), product.getId(), imageId);
        MockMultipartFile newImageFile = ImageFixture.JPEG_IMAGE2.toMultipartFile();
        List<String> hashTags = ReviewFixture.참이슬_치킨.getHashtags();

        ReviewUpdateRequest request = ReviewUpdateRequest.builder()
                .id(review.getId())
                .productId(product.getId())
                .productRate(review.getProductRate())
                .content(review.getContent())
                .foodRate(review.getFoodRate())
                .foodCategory(review.getFoodCategory().getCategory())
                .foodImageId(imageId)
                .hashtags(hashTags)
                .build();

        reviewModifyService.update(new AuthMember(member.getId()), request, newImageFile);

        Review actual = reviewFindService.findById(review.getId());
        assertThat(actual.getImage().getName().equals(ImageFixture.JPEG_IMAGE2.name()));
    }

    @DisplayName("리뷰의 해시태그를 수정한다.")
    @Test
    void 리뷰의_해시태그를_수정한다() {

        Long imageId = saveImage(ImageFixture.JPEG_IMAGE).getImageId();

        review = saveReviewInfo(ReviewFixture.참이슬_치킨, member.getId(), product.getId(), imageId);
        MockMultipartFile imageFile = ImageFixture.JPEG_IMAGE.toMultipartFile();
        List<String> hashTags = ReviewFixture.산토리위스키_치즈3.getHashtags();     // 수정할 해시태그

        ReviewUpdateRequest request = ReviewUpdateRequest.builder()
                .id(review.getId())
                .productId(product.getId())
                .productRate(review.getProductRate())
                .content(review.getContent())
                .foodRate(review.getFoodRate())
                .foodCategory(review.getFoodCategory().getCategory())
                .foodImageId(imageId)
                .hashtags(hashTags)
                .build();

        reviewModifyService.update(new AuthMember(member.getId()), request, imageFile);

        Review actual = reviewFindService.findById(review.getId());
        assertThat(actual.getReviewHashtags().size()).isEqualTo(3);
    }
}