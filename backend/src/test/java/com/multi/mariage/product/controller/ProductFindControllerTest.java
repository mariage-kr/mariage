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
import org.springframework.test.web.servlet.ResultActions;

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
        saveReview(ReviewFixture.참이슬_과자, image2.getId(), product.getId(), member.getId());

        mockMvc.perform(get("/api/product/recommend/date")
                        .param("size", String.valueOf(size))
                        .param("option", "total"))
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

        mockMvc.perform(get("/api/product/recommend/date")
                        .param("size", String.valueOf(size))
                        .param("option", "month"))
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

        mockMvc.perform(get("/api/product/recommend/date")
                        .param("size", String.valueOf(size))
                        .param("option", "week"))
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

    @DisplayName("상세페이지의 전체 정보를 조회한다.")
    @Test
    void 상세페이지의_전체_정보를_조회한다() throws Exception {
        Member member = saveMember();
        Product product = saveProduct(ProductFixture.참이슬, saveImage(ImageFixture.JPEG_IMAGE).getId());
        Long productId = product.getId();
        Image image2 = saveImage(ImageFixture.JPEG_IMAGE2);
        saveReview(ReviewFixture.참이슬_과자, image2.getId(), product.getId(), member.getId());

        mockMvc.perform(get("/api/product/detail/" + productId))
                .andDo(print())
                .andDo(document("Product/Detail",
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("productId").description("제품 식별자"),
                                        fieldWithPath("content").description("제품 정보"),
                                        fieldWithPath("content.imageId").description("제품 이미지 식별자"),
                                        fieldWithPath("content.imageUrl").description("제품 이미지 url"),
                                        fieldWithPath("content.name").description("제품 이름"),
                                        fieldWithPath("content.level").description("제품의 도수"),
                                        fieldWithPath("content.reviewRate").description("제품에 대한 리뷰 평점"),
                                        fieldWithPath("content.info").description("제품 정보"),
                                        fieldWithPath("content.countryId").description("제품의 제조국 식별자"),
                                        fieldWithPath("content.country").description("제품의 제조국 이름"),
                                        fieldWithPath("rating").description("제품에 대한 별점 통계"),
                                        fieldWithPath("rating.reviewAverageRate").description("제품에 대한 리뷰의 평균 점수"),
                                        fieldWithPath("rating.reviewCount").description("제품에 대한 리뷰 개수"),
                                        fieldWithPath("rating.percentageList").description("제품에 대한 점수별 리뷰 비율"),
                                        fieldWithPath("rating.percentageList[].reviewRate").description("리뷰 점수"),
                                        fieldWithPath("rating.percentageList[].percentage").description("전체 리뷰 중 차지하는 비율"),
                                        fieldWithPath("foodRateRanking").description("제품의 궁합 음식 별점순 랭킹"),
                                        fieldWithPath("foodRateRanking[].foodId").description("궁합 음식 식별자"),
                                        fieldWithPath("foodRateRanking[].category").description("궁합 음식 카테고리"),
                                        fieldWithPath("foodRateRanking[].avgFoodRate").description("제품과의 궁합 평균 점수"),
                                        fieldWithPath("foodCountRanking").description("제품의 궁합 음식 리뷰순 랭킹"),
                                        fieldWithPath("foodCountRanking[].foodId").description("궁합 음식 식별자"),
                                        fieldWithPath("foodCountRanking[].category").description("궁합 음식 카테고리"),
                                        fieldWithPath("foodCountRanking[].reviewCount").description("사용자가 궁합 음식으로 채택한 리뷰 개수")
                                )
                        )
                )
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @DisplayName("필터 조건으로 제품을 조회한다.")
    @Test
    void 필터_조건으로_제품을_조회한다() throws Exception {
        Member member = saveMember();
        Image image1 = saveImage(ImageFixture.JPEG_IMAGE);
        Image image2 = saveImage(ImageFixture.JPEG_IMAGE2);
        Image image3 = saveImage(ImageFixture.JPEG_IMAGE3);
        Product product1 = saveProduct(ProductFixture.참이슬, image1.getId());
        Product product2 = saveProduct(ProductFixture.산토리_위스키, image2.getId());
        saveReview(ReviewFixture.참이슬_과자, image3.getId(), product1.getId(), member.getId());

        mockMvc.perform(get("/api/product/find/filter")
                        .param("pageSize", "10")
                        .param("pageNumber", "1")
                        .param("sort", "count")
                        .param("minRate", "0")
                        .param("maxRate", "5")
                        .param("minLevel", "0")
                        .param("maxLevel", "70"))
                .andDo(print())
                .andDo(document("Product/Filter",
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("contents").description("제품 목록"),
                                        fieldWithPath("contents[].id").description("제품 식별 번호"),
                                        fieldWithPath("contents[].name").description("제품 이름"),
                                        fieldWithPath("contents[].level").description("제품 알코올 도수"),
                                        fieldWithPath("contents[].imageUrl").description("제품 사진 Url"),
                                        fieldWithPath("contents[].country").description("제품 제조국"),
                                        fieldWithPath("contents[].country.countryId").description("제품 제조국 식별 번호"),
                                        fieldWithPath("contents[].country.country").description("제품 제조국 이름"),
                                        fieldWithPath("contents[].review").description("제품 리뷰 정보"),
                                        fieldWithPath("contents[].review.reviewRate").description("제품 평균 리뷰 점수"),
                                        fieldWithPath("contents[].review.reviewCount").description("제품 리뷰 횟수"),
                                        fieldWithPath("contents[].foods").description("제품 음식 카테고리"),
                                        fieldWithPath("contents[].foods[].id").description("제품 음식 카테고리 고유 식별 번호"),
                                        fieldWithPath("contents[].foods[].name").description("제품 음식 카테고리 이름"),
                                        fieldWithPath("pageNumber").description("페이지 번호"),
                                        fieldWithPath("totalCount").description("전체 상품의 개수"),
                                        fieldWithPath("pageSize").description("페이지 크기"),
                                        fieldWithPath("totalPages").description("전체 페이지 개수"),
                                        fieldWithPath("firstPage").description("첫번째 페이지 확인"),
                                        fieldWithPath("lastPage").description("마지막 페이지 확인")
                                )
                        )
                ).andExpect(status().isOk());
    }

    @DisplayName("제품을 검색한다.")
    @Test
    void 제품을_검색한다() throws Exception {
        Member member = saveMember();
        Image image1 = saveImage(ImageFixture.JPEG_IMAGE);
        Image image2 = saveImage(ImageFixture.JPEG_IMAGE2);
        Image image3 = saveImage(ImageFixture.JPEG_IMAGE3);
        Product product1 = saveProduct(ProductFixture.참이슬, image1.getId());
        Product product2 = saveProduct(ProductFixture.산토리_위스키, image2.getId());
        saveReview(ReviewFixture.참이슬_과자, image3.getId(), product1.getId(), member.getId());

        mockMvc.perform(get("/api/product/find/filter")
                        .param("search", ProductFixture.참이슬.name())
                        .param("pageSize", "10")
                        .param("pageNumber", "1")
                        .param("sort", "count")
                        .param("minRate", "0")
                        .param("maxRate", "5")
                        .param("minLevel", "0")
                        .param("maxLevel", "70"))
                .andDo(print())
                .andDo(document("Product/Filter",
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("contents").description("제품 목록"),
                                        fieldWithPath("contents[].id").description("제품 식별 번호"),
                                        fieldWithPath("contents[].name").description("제품 이름"),
                                        fieldWithPath("contents[].level").description("제품 알코올 도수"),
                                        fieldWithPath("contents[].imageUrl").description("제품 사진 Url"),
                                        fieldWithPath("contents[].country").description("제품 제조국"),
                                        fieldWithPath("contents[].country.countryId").description("제품 제조국 식별 번호"),
                                        fieldWithPath("contents[].country.country").description("제품 제조국 이름"),
                                        fieldWithPath("contents[].review").description("제품 리뷰 정보"),
                                        fieldWithPath("contents[].review.reviewRate").description("제품 평균 리뷰 점수"),
                                        fieldWithPath("contents[].review.reviewCount").description("제품 리뷰 횟수"),
                                        fieldWithPath("contents[].foods").description("제품 음식 카테고리"),
                                        fieldWithPath("contents[].foods[].id").description("제품 음식 카테고리 고유 식별 번호"),
                                        fieldWithPath("contents[].foods[].name").description("제품 음식 카테고리 이름"),
                                        fieldWithPath("pageNumber").description("페이지 번호"),
                                        fieldWithPath("totalCount").description("전체 상품의 개수"),
                                        fieldWithPath("pageSize").description("페이지 크기"),
                                        fieldWithPath("totalPages").description("전체 페이지 개수"),
                                        fieldWithPath("firstPage").description("첫번째 페이지 확인"),
                                        fieldWithPath("lastPage").description("마지막 페이지 확인")
                                )
                        )
                ).andExpect(status().isOk());
    }
}