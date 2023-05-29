package com.multi.mariage.review.controller;

import com.multi.mariage.auth.vo.AuthMember;
import com.multi.mariage.common.annotation.ControllerTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.common.fixture.ReviewFixture;
import com.multi.mariage.like.dto.request.LikeSaveRequest;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.domain.Sort;
import com.multi.mariage.review.dto.response.ReviewSaveResponse;
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
    private ReviewSaveResponse reviewSaveResponse;

    @BeforeEach
    void setUp() {
        member = saveMember();
        Image image1 = saveImage(ImageFixture.JPEG_IMAGE);
        Image image2 = saveImage(ImageFixture.JPEG_IMAGE2);
        Image image3 = saveImage(ImageFixture.JPEG_IMAGE3);
        product = saveProduct(ProductFixture.참이슬, image1.getId());
        reviewSaveResponse = saveReview(ReviewFixture.참이슬_과자, image2.getId(), product.getId(), member.getId());
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
        mockMvc.perform(get("/api/review/member/ratings")
                        .param("memberId", memberId)
                        .param("pageNumber", "1")
                        .param("pageSize", "2")
                        .param("sort", Sort.NEWEST.name()))
                .andDo(print())
                .andDo(document("Review/FindReviews/Member/Ratings",
                        preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("contents").description("사용자가 작성한 리뷰 목록"),
                                fieldWithPath("contents[].productInfo.id").description("제품 식별 번호"),
                                fieldWithPath("contents[].productInfo.imageId").description("제품 사진 식별 번호"),
                                fieldWithPath("contents[].productInfo.imageUrl").description("제품 사진 Url"),
                                fieldWithPath("contents[].productInfo.name").description("제품 이름"),
                                fieldWithPath("contents[].productInfo.level").description("제품 도수"),
                                fieldWithPath("contents[].productInfo.reviewRate").description("제품 평균 평가 점수"),
                                fieldWithPath("contents[].productInfo.info").description("제품 정보"),
                                fieldWithPath("contents[].productInfo.countryId").description("제품 제조국 식별 번호"),
                                fieldWithPath("contents[].productInfo.country").description("제품 제조국"),
                                fieldWithPath("contents[].reviewInfo.id").description("리뷰 식별 번호"),
                                fieldWithPath("contents[].reviewInfo.member").description("리뷰를 작성한 사용자"),
                                fieldWithPath("contents[].reviewInfo.member.id").description("리뷰를 작성한 사용자 식별 번호"),
                                fieldWithPath("contents[].reviewInfo.member.nickname").description("리뷰를 작성한 사용자 별칭"),
                                fieldWithPath("contents[].reviewInfo.member.img").description("리뷰를 작성한 사용자 프로필 사진 Url"),
                                fieldWithPath("contents[].reviewInfo.review").description("리뷰 내용"),
                                fieldWithPath("contents[].reviewInfo.review.date").description("리뷰 작성 날짜"),
                                fieldWithPath("contents[].reviewInfo.review.content").description("제품 평가 내용"),
                                fieldWithPath("contents[].reviewInfo.review.rate").description("제품 평가 점수"),
                                fieldWithPath("contents[].reviewInfo.review.img").description("리뷰 사진"),
                                fieldWithPath("contents[].reviewInfo.like").description("리뷰의 좋아요 정보"),
                                fieldWithPath("contents[].reviewInfo.like.count").description("좋아요의 개수"),
                                fieldWithPath("contents[].reviewInfo.like.liked").description("좋아요 유무"),
                                fieldWithPath("contents[].reviewInfo.food").description("리뷰한 제품의 궁합 음식 정보"),
                                fieldWithPath("contents[].reviewInfo.food.id").description("음식 카테고리 식별 번호"),
                                fieldWithPath("contents[].reviewInfo.food.name").description("음식 카테고리 이름"),
                                fieldWithPath("contents[].reviewInfo.food.rate").description("궁합 음식의 평가 점수 "),
                                fieldWithPath("contents[].reviewInfo.hashtags").description("해시 태그 모음"),
                                fieldWithPath("pageNumber").description("조회한 페이지 번호"),
                                fieldWithPath("totalCount").description("전체 리뷰 개수"),
                                fieldWithPath("pageSize").description("페이지 크기"),
                                fieldWithPath("totalPages").description("전체 페이지의 개수"),
                                fieldWithPath("firstPage").description("첫번째 페이지의 유무"),
                                fieldWithPath("lastPage").description("마지막 페이지의 유무")
                        ))
                ).andExpect(status().isOk());
    }

    @DisplayName("사용자가 좋아요한 리뷰를 조회한다.")
    @Test
    void 사용자가_좋아요한_리뷰를_조회한다() throws Exception {
        String memberId = String.valueOf(member.getId());
        LikeSaveRequest likeSaveRequest = new LikeSaveRequest(reviewSaveResponse.getReviewId());
        likeReview(new AuthMember(member.getId()), likeSaveRequest);

        mockMvc.perform(get("/api/review/member/likes")
                        .param("memberId", memberId)
                        .param("pageNumber", "1")
                        .param("pageSize", "1")
                        .param("sort", Sort.NEWEST.name()))
                .andDo(print())
                .andDo(document("Review/FindReviews/Member/Likes",
                        preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("contents").description("사용자가 좋아요한 리뷰 목록"),
                                fieldWithPath("contents[].productInfo.id").description("제품 식별 번호"),
                                fieldWithPath("contents[].productInfo.imageId").description("제품 사진 식별 번호"),
                                fieldWithPath("contents[].productInfo.imageUrl").description("제품 사진 Url"),
                                fieldWithPath("contents[].productInfo.name").description("제품 이름"),
                                fieldWithPath("contents[].productInfo.level").description("제품 도수"),
                                fieldWithPath("contents[].productInfo.reviewRate").description("제품 평균 평가 점수"),
                                fieldWithPath("contents[].productInfo.info").description("제품 정보"),
                                fieldWithPath("contents[].productInfo.countryId").description("제품 제조국 식별 번호"),
                                fieldWithPath("contents[].productInfo.country").description("제품 제조국"),
                                fieldWithPath("contents[].reviewInfo.id").description("리뷰 식별 번호"),
                                fieldWithPath("contents[].reviewInfo.member").description("리뷰를 작성한 사용자"),
                                fieldWithPath("contents[].reviewInfo.member.id").description("리뷰를 작성한 사용자 식별 번호"),
                                fieldWithPath("contents[].reviewInfo.member.nickname").description("리뷰를 작성한 사용자 별칭"),
                                fieldWithPath("contents[].reviewInfo.member.img").description("리뷰를 작성한 사용자 프로필 사진 Url"),
                                fieldWithPath("contents[].reviewInfo.review").description("리뷰 내용"),
                                fieldWithPath("contents[].reviewInfo.review.date").description("리뷰 작성 날짜"),
                                fieldWithPath("contents[].reviewInfo.review.content").description("제품 평가 내용"),
                                fieldWithPath("contents[].reviewInfo.review.rate").description("제품 평가 점수"),
                                fieldWithPath("contents[].reviewInfo.review.img").description("리뷰 사진"),
                                fieldWithPath("contents[].reviewInfo.like").description("리뷰의 좋아요 정보"),
                                fieldWithPath("contents[].reviewInfo.like.count").description("좋아요의 개수"),
                                fieldWithPath("contents[].reviewInfo.like.liked").description("좋아요 유무"),
                                fieldWithPath("contents[].reviewInfo.food").description("리뷰한 제품의 궁합 음식 정보"),
                                fieldWithPath("contents[].reviewInfo.food.id").description("음식 카테고리 식별 번호"),
                                fieldWithPath("contents[].reviewInfo.food.name").description("음식 카테고리 이름"),
                                fieldWithPath("contents[].reviewInfo.food.rate").description("궁합 음식의 평가 점수 "),
                                fieldWithPath("contents[].reviewInfo.hashtags").description("해시 태그 모음"),
                                fieldWithPath("pageNumber").description("조회한 페이지 번호"),
                                fieldWithPath("totalCount").description("전체 리뷰 개수"),
                                fieldWithPath("pageSize").description("페이지 크기"),
                                fieldWithPath("totalPages").description("전체 페이지의 개수"),
                                fieldWithPath("firstPage").description("첫번째 페이지의 유무"),
                                fieldWithPath("lastPage").description("마지막 페이지의 유무")
                        ))
                ).andExpect(status().isOk());
    }

    @DisplayName("사용자의 프로필을 조회한다.")
    @Test
    void 사용자의_프로필을_조회한다() throws Exception {
        mockMvc.perform(get("/api/review/member/" + member.getId()))
                .andDo(print())
                .andDo(
                        document("Review/FindReviews/Member/Profile",
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("email").description("사용자 이메일"),
                                        fieldWithPath("imagePath").description("프로필 이미지 경로"),
                                        fieldWithPath("nickname").description("사용자 별칭"),
                                        fieldWithPath("reviews").description("사용자가 작성한 리뷰 개수"),
                                        fieldWithPath("likes").description("사용자가 좋아요한 리뷰 개수")
                                )
                        )
                )
                .andExpect(status().isOk());
    }
}