package com.multi.mariage.review.controller;

import com.multi.mariage.common.annotation.ControllerTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.common.fixture.ReviewFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.domain.Sort;
import com.multi.mariage.storage.domain.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ReviewFindControllerTest extends ControllerTest {

    private Member member;
    private Product product;

    @BeforeEach
    void setUp() {
        member = saveMember();
        Image image1 = saveImage(ImageFixture.JPEG_IMAGE);
        Image image2 = saveImage(ImageFixture.JPEG_IMAGE2);
        Image image3 = saveImage(ImageFixture.JPEG_IMAGE3);
        product = saveProduct(ProductFixture.참이슬, image1.getId());
        saveReview(ReviewFixture.참이슬_과자, image2.getId(), product.getId(), member.getId());
        saveReview(ReviewFixture.참이슬_치킨, image3.getId(), product.getId(), member.getId());
    }

    @DisplayName("제품의 리뷰를 조회한다.")
    @Test
    void 제품의_리뷰를_조회한다() throws Exception {
        String memberId = String.valueOf(member.getId());
        mockMvc.perform(get("/api/review/product/" + product.getId())
                        .param("memberId", memberId)
                        .param("pageNumber", "1")
                        .param("pageSize", "2")
                        .param("sort", Sort.NEWEST.name()))
                .andDo(print())
                .andDo(document("Review/FindReviews",
                        preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("contents").description("조회한 리뷰 목록"),
                                fieldWithPath("contents[].id").description("리뷰 식별 번호"),
                                fieldWithPath("contents[].member").description("리뷰를 작성한 사용자"),
                                fieldWithPath("contents[].member.id").description("리뷰를 작성한 사용자 식별 번호"),
                                fieldWithPath("contents[].member.nickname").description("리뷰를 작성한 사용자 별칭"),
                                fieldWithPath("contents[].member.img").description("리뷰를 작성한 사용자 프로필 사진 Url"),
                                fieldWithPath("contents[].review").description("리뷰 내용"),
                                fieldWithPath("contents[].review.date").description("리뷰 작성 날짜"),
                                fieldWithPath("contents[].review.content").description("제품 평가 내용"),
                                fieldWithPath("contents[].review.rate").description("제품 평가 점수"),
                                fieldWithPath("contents[].review.img").description("리뷰 사진"),
                                fieldWithPath("contents[].review.weather").description("리뷰가 작성될 때의 날씨"),
                                fieldWithPath("contents[].like").description("리뷰의 좋아요 정보"),
                                fieldWithPath("contents[].like.liked").description("좋아요 유무"),
                                fieldWithPath("contents[].like.count").description("좋아요의 개수"),
                                fieldWithPath("contents[].food").description("리뷰한 제품의 궁합 음식 정보"),
                                fieldWithPath("contents[].food.id").description("음식 카테고리 식별 번호"),
                                fieldWithPath("contents[].food.name").description("음식 카테고리 이름"),
                                fieldWithPath("contents[].food.rate").description("궁합 음식의 평가 점수 "),
                                fieldWithPath("contents[].hashtags").description("해시 태그 모음"),
                                fieldWithPath("pageNumber").description("조회한 페이지 번호"),
                                fieldWithPath("totalCount").description("전체 리뷰 개수"),
                                fieldWithPath("pageSize").description("페이지 크기"),
                                fieldWithPath("totalPages").description("전체 페이지의 개수"),
                                fieldWithPath("firstPage").description("첫번째 페이지의 유무"),
                                fieldWithPath("lastPage").description("마지막 페이지의 유무")
                        ))
                ).andExpect(status().isOk());
    }
    @DisplayName("사용자가 작성한 리뷰를 조회한다.")
    @Test
    void 사용자가_작성한_리뷰를_조회한다() throws Exception {
        String memberId = String.valueOf(member.getId());
        mockMvc.perform(get("/api/review/member/write")
                        .param("memberId", memberId)
                        .param("pageNumber", "1")
                        .param("pageSize", "2")
                        .param("sort", Sort.NEWEST.name()))
                .andDo(print())
                .andDo(document("Review/FindReviews/Member/Write",
                        preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("contents").description("조회한 리뷰 목록"),
                                fieldWithPath("contents[].productContent.id").description("제품 식별 번호"),
                                fieldWithPath("contents[].productContent.imageId").description("제품 사진 식별 번호"),
                                fieldWithPath("contents[].productContent.imageUrl").description("제품 사진 Url"),
                                fieldWithPath("contents[].productContent.name").description("제품 이름"),
                                fieldWithPath("contents[].productContent.level").description("제품 도수"),
                                fieldWithPath("contents[].productContent.reviewRate").description("제품 평균 평가 점수"),
                                fieldWithPath("contents[].productContent.info").description("제품 정보"),
                                fieldWithPath("contents[].productContent.countryId").description("제품 제조국 식별 번호"),
                                fieldWithPath("contents[].productContent.country").description("제품 제조국"),
                                fieldWithPath("contents[].productReview.id").description("리뷰 식별 번호"),
                                fieldWithPath("contents[].productReview.member").description("리뷰를 작성한 사용자"),
                                fieldWithPath("contents[].productReview.member.id").description("리뷰를 작성한 사용자 식별 번호"),
                                fieldWithPath("contents[].productReview.member.nickname").description("리뷰를 작성한 사용자 별칭"),
                                fieldWithPath("contents[].productReview.member.img").description("리뷰를 작성한 사용자 프로필 사진 Url"),
                                fieldWithPath("contents[].productReview.review").description("리뷰 내용"),
                                fieldWithPath("contents[].productReview.review.date").description("리뷰 작성 날짜"),
                                fieldWithPath("contents[].productReview.review.content").description("제품 평가 내용"),
                                fieldWithPath("contents[].productReview.review.rate").description("제품 평가 점수"),
                                fieldWithPath("contents[].productReview.review.img").description("리뷰 사진"),
                                fieldWithPath("contents[].productReview.like").description("리뷰의 좋아요 정보"),
                                fieldWithPath("contents[].productReview.like.count").description("좋아요의 개수"),
                                fieldWithPath("contents[].productReview.like.liked").description("좋아요 유무"),
                                fieldWithPath("contents[].productReview.food").description("리뷰한 제품의 궁합 음식 정보"),
                                fieldWithPath("contents[].productReview.food.id").description("음식 카테고리 식별 번호"),
                                fieldWithPath("contents[].productReview.food.name").description("음식 카테고리 이름"),
                                fieldWithPath("contents[].productReview.food.rate").description("궁합 음식의 평가 점수 "),
                                fieldWithPath("contents[].productReview.hashtags").description("해시 태그 모음"),
                                fieldWithPath("pageNumber").description("조회한 페이지 번호"),
                                fieldWithPath("totalCount").description("전체 리뷰 개수"),
                                fieldWithPath("pageSize").description("페이지 크기"),
                                fieldWithPath("totalPages").description("전체 페이지의 개수"),
                                fieldWithPath("firstPage").description("첫번째 페이지의 유무"),
                                fieldWithPath("lastPage").description("마지막 페이지의 유무")
                        ))
                ).andExpect(status().isOk());
    }
}