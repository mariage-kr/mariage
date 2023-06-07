package com.multi.mariage.review.controller;

import com.multi.mariage.common.annotation.ControllerTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.common.fixture.ReviewFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.dto.response.ReviewSaveResponse;
import com.multi.mariage.storage.domain.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class ReviewModifyControllerTest extends ControllerTest {

    private String ACCESS_TOKEN;
    private Member member;

    @BeforeEach
    void setUp() {
        member = saveMember();
        ACCESS_TOKEN = accessToken(MemberFixture.MARI);
    }

    @DisplayName("사용자가 리뷰를 작성한다.")
    @Test
    void 사용자가_리뷰를_작성한다() throws Exception {
        Image image = saveImage(ImageFixture.JPEG_IMAGE);
        Product product = saveProduct(ProductFixture.참이슬, image.getId());

        String content = objectMapper.writeValueAsString(ReviewFixture.참이슬_과자.toSaveRequest(product.getId(), image.getId()));

        mockMvc.perform(post("/api/user/review/save")
                        .content(content)
                        .header(AUTHORIZATION, BEARER_PREFIX + ACCESS_TOKEN)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andDo(
                        document("Review/Save",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                requestFields(
                                        fieldWithPath("productId").description("제품 고유 식별자"),
                                        fieldWithPath("productRate").description("제품 평가 점수"),
                                        fieldWithPath("content").description("리뷰 내용"),
                                        fieldWithPath("foodRate").description("궁합 음식 평가 점수"),
                                        fieldWithPath("foodCategory").description("궁합 음식 분류"),
                                        fieldWithPath("foodImageId").description("음식 사진"),
                                        fieldWithPath("hashtags").description("리뷰의 해시태그")
                                ),
                                responseFields(
                                        fieldWithPath("reviewId").description("리뷰의 고유 식별자")
                                )
                        )
                ).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @DisplayName("리뷰를 수정한다")
    @Test
    void 리뷰를_수정한다() throws Exception {
        Image image = saveImage(ImageFixture.JPEG_IMAGE);
        Product product = saveProduct(ProductFixture.참이슬, image.getId());
        ReviewSaveResponse review = saveReview(ReviewFixture.참이슬_치킨, image.getId(), product.getId(), member.getId());

        Image newImage = saveImage(ImageFixture.JPEG_IMAGE2);
        String content = objectMapper.writeValueAsString(ReviewFixture.참이슬_치킨.toUpdateRequest(review.getReviewId(), product.getId(), newImage.getId()));

        mockMvc.perform(patch("/api/user/review/update")
                        .content(content)
                        .header(AUTHORIZATION, BEARER_PREFIX + ACCESS_TOKEN)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andDo(
                        document("Review/Update",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                requestFields(
                                        fieldWithPath("reviewId").description("수정할 리뷰 식별 번호"),
                                        fieldWithPath("productRate").description("제품 평가 점수"),
                                        fieldWithPath("content").description("리뷰 내용"),
                                        fieldWithPath("foodRate").description("궁합 음식 평가 점수"),
                                        fieldWithPath("foodCategory").description("궁합 음식 분류"),
                                        fieldWithPath("newImageId").description("수정할 리뷰 사진"),
                                        fieldWithPath("hashtags").description("리뷰의 해시태그")
                                ),
                                responseFields(
                                        fieldWithPath("reviewId").description("수정할 리뷰 식별 번호"),
                                        fieldWithPath("productRate").description("제품 평가 점수"),
                                        fieldWithPath("content").description("리뷰 내용"),
                                        fieldWithPath("foodRate").description("궁합 음식 평가 점수"),
                                        fieldWithPath("foodCategory").description("궁합 음식 분류"),
                                        fieldWithPath("imagePath").description("수정할 리뷰 사진 경로"),
                                        fieldWithPath("hashtags").description("리뷰의 해시태그")
                                )
                        )
                ).andExpect(MockMvcResultMatchers.status().isCreated());
    }
}