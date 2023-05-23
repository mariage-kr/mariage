package com.multi.mariage.product.controller;

import com.multi.mariage.common.annotation.ControllerTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.common.fixture.ReviewFixture;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.storage.domain.Image;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductFindControllerTest extends ControllerTest {
    @DisplayName("상세페이지의 제품 정보를 조회한다.")
    @Test
    void 상세페이지의_제품_정보를_조회한다() throws Exception {

        Product product = saveProduct(ProductFixture.참이슬, saveImage(ImageFixture.JPEG_IMAGE).getId());
        Long productId = product.getId();

        mockMvc.perform(get("/api/product/detail/" + productId))
                .andDo(print())
                .andDo(document("Product/Detail",
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("id").description("제품 식별자"),
                                        fieldWithPath("imageId").description("제품 이미지 식별자"),
                                        fieldWithPath("imageUrl").description("제품 이미지 url"),
                                        fieldWithPath("name").description("제품 이름"),
                                        fieldWithPath("level").description("제품의 도수"),
                                        fieldWithPath("reviewRate").description("제품에 대한 리뷰 평점"),
                                        fieldWithPath("info").description("제품 정보"),
                                        fieldWithPath("countryId").description("제품의 제조국 식별자"),
                                        fieldWithPath("country").description("제품의 제조국 이름")
                                )
                        )
                )
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @DisplayName("전체기간 동안 가장많이 리뷰가 작성된 제품들을 추천한다.")
    @Test
    void 전체기간_동안_가장많이_리뷰가_작성된_제품들을_추천한다() throws Exception {

        int size = 1;

        Member member = saveMember();
        Product product = saveProduct(ProductFixture.참이슬, saveImage(ImageFixture.JPEG_IMAGE).getId());
        Image image2 = saveImage(ImageFixture.JPEG_IMAGE2);
        saveReview(ReviewFixture.참이슬_과자, image2.getId(), product.getId(), member.getId());

        mockMvc.perform(get("/api/product/recommend/total")
                        .param("size", String.valueOf(size)))
                .andDo(print())
                .andDo(
                        document("Product/RecommendByTotal",
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("[].productId").description("제품 식별 번호"),
                                        fieldWithPath("[].productName").description("제품 이름"),
                                        fieldWithPath("[].productImageUrl").description("제품 사진의 URL"),
                                        fieldWithPath("[].reviewCount").description("제품 리뷰 개수"),
                                        fieldWithPath("[].reviewRate").description("제품 리뷰 평균 점수"),
                                        fieldWithPath("[].country").description("제조국"),
                                        fieldWithPath("[].countryId").description("제조국 식별 번호")
                                )
                        )
                ).andExpect(status().isOk());
    }

    @DisplayName("한달 동안 가장많이 리뷰가 작성된 제품을 추천한다.")
    @Test
    void 한달_동안_가장많이_리뷰가_작성된_제품을_추천한다() throws Exception {
        int size = 1;

        Member member = saveMember();
        Product product = saveProduct(ProductFixture.참이슬, saveImage(ImageFixture.JPEG_IMAGE).getId());
        Image image2 = saveImage(ImageFixture.JPEG_IMAGE2);
        saveReview(ReviewFixture.참이슬_과자, image2.getId(), product.getId(), member.getId());

        mockMvc.perform(get("/api/product/recommend/month")
                        .param("size", String.valueOf(size)))
                .andDo(print())
                .andDo(
                        document("Product/RecommendByTotal",
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("[].productId").description("제품 식별 번호"),
                                        fieldWithPath("[].productName").description("제품 이름"),
                                        fieldWithPath("[].productImageUrl").description("제품 사진의 URL"),
                                        fieldWithPath("[].reviewCount").description("제품 리뷰 개수"),
                                        fieldWithPath("[].reviewRate").description("제품 리뷰 평균 점수"),
                                        fieldWithPath("[].country").description("제조국"),
                                        fieldWithPath("[].countryId").description("제조국 식별 번호")
                                )
                        )
                ).andExpect(status().isOk());
    }

    @DisplayName("일주일 동안 가장많이 리뷰가 작성된 제품을 추천한다.")
    @Test
    void 일주일_동안_가장많이_리뷰가_작성된_제품을_추천한다() throws Exception {
        int size = 1;

        Member member = saveMember();
        Product product = saveProduct(ProductFixture.참이슬, saveImage(ImageFixture.JPEG_IMAGE).getId());
        Image image2 = saveImage(ImageFixture.JPEG_IMAGE2);
        saveReview(ReviewFixture.참이슬_과자, image2.getId(), product.getId(), member.getId());

        mockMvc.perform(get("/api/product/recommend/week")
                        .param("size", String.valueOf(size)))
                .andDo(print())
                .andDo(
                        document("Product/RecommendByTotal",
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("[].productId").description("제품 식별 번호"),
                                        fieldWithPath("[].productName").description("제품 이름"),
                                        fieldWithPath("[].productImageUrl").description("제품 사진의 URL"),
                                        fieldWithPath("[].reviewCount").description("제품 리뷰 개수"),
                                        fieldWithPath("[].reviewRate").description("제품 리뷰 평균 점수"),
                                        fieldWithPath("[].country").description("제조국"),
                                        fieldWithPath("[].countryId").description("제조국 식별 번호")
                                )
                        )
                ).andExpect(status().isOk());
    }
}