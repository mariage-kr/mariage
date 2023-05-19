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

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductFindControllerTest extends ControllerTest {

    @DisplayName("전체기간 동안 가장많이 리뷰가 작성된 제품들을 추천한다.")
    @Test
    void 전체기간_동안_가장많이_리뷰가_작성된_제품들을_추천한다() throws Exception {

        int size = 1;

        Member member = saveMember();
        Product product = saveProduct(ProductFixture.참이슬, saveImage(ImageFixture.JPEG_IMAGE).getId());
        Image image2 = saveImage(ImageFixture.JPEG_IMAGE2);
        saveReview(member, ReviewFixture.참이슬_과자, product, image2);

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
                                        fieldWithPath("[].countryImageUrl").description("제조국 국기 사진의 URL")
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
        saveReview(member, ReviewFixture.참이슬_과자, product, image2);

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
                                        fieldWithPath("[].countryImageUrl").description("제조국 국기 사진의 URL")
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
        saveReview(member, ReviewFixture.참이슬_과자, product, image2);

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
                                        fieldWithPath("[].countryImageUrl").description("제조국 국기 사진의 URL")
                                )
                        )
                ).andExpect(status().isOk());
    }
}