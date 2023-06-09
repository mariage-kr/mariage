package com.multi.mariage.like.controller;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.common.annotation.ControllerTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.common.fixture.ReviewFixture;
import com.multi.mariage.like.dto.request.LikeSaveRequest;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class LikeControllerTest extends ControllerTest {
    private String ACCESS_TOKEN;
    private ReviewSaveResponse reviewSaveResponse;
    private Member member;
    private AuthMember authMember;

    @BeforeEach
    void setUp() {

        member = saveMember();
        ACCESS_TOKEN = accessToken(MemberFixture.MARI);
        Image image = saveImage(ImageFixture.JPEG_IMAGE);
        Product product = saveProduct(ProductFixture.참이슬, image.getId());
        authMember = new AuthMember(member.getId());

        reviewSaveResponse = saveReview(ReviewFixture.참이슬_치킨, image.getId(), product.getId(), authMember.getId());

    }

    @DisplayName("사용자가 좋아요를 누른다.")
    @Test
    void 사용자가_좋아요를_누른다() throws Exception {

        LikeSaveRequest likeSaveRequest = new LikeSaveRequest(reviewSaveResponse.getReviewId());
        String content = objectMapper.writeValueAsString(likeSaveRequest);

        mockMvc.perform(post("/api/user/review/like")
                        .header(AUTHORIZATION, BEARER_PREFIX + ACCESS_TOKEN)
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andDo(
                        document("Like/Like",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                requestFields(
                                        fieldWithPath("reviewId").description("리뷰 식별자")
                                ),
                                responseFields(
                                        fieldWithPath("likedCount").description("좋아요 개수")
                                )
                        )
                ).andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @DisplayName("사용자가 좋아요를 취소한다.")
    @Test
    void 사용자가_좋아요를_취소한다() throws Exception {
        LikeSaveRequest likeSaveRequest = new LikeSaveRequest(reviewSaveResponse.getReviewId());
        likeReview(authMember, likeSaveRequest);
        String reviewId = String.valueOf(reviewSaveResponse.getReviewId());

        mockMvc.perform(delete("/api/user/review/like")
                        .header(AUTHORIZATION, BEARER_PREFIX + ACCESS_TOKEN)
                        .param("reviewId", reviewId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andDo(
                        document("Like/Cancel",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("likedCount").description("좋아요 개수")
                                )
                        )
                ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}