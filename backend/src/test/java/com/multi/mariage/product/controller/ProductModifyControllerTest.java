package com.multi.mariage.product.controller;

import com.multi.mariage.common.annotation.ControllerTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.common.fixture.MemberFixture;
import com.multi.mariage.common.fixture.ProductFixture;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.storage.domain.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductModifyControllerTest extends ControllerTest {
    private String ACCESS_TOKEN;

    @BeforeEach
    void setUp() {
        saveMember();
        ACCESS_TOKEN = accessToken(MemberFixture.MARI);
    }

    @DisplayName("제품을 저정한다.")
    @Test
    void 제품을_저장한다() throws Exception {
        Image image = saveImage(ImageFixture.JPEG_IMAGE);
        String content = objectMapper.writeValueAsString(ProductFixture.참이슬.toProductSaveRequest(image.getId()));

        mockMvc.perform(post("/api/user/product/save")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(AUTHORIZATION, BEARER_PREFIX + ACCESS_TOKEN))
                .andDo(print())
                .andDo(
                        document("Product/Save",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                requestFields(
                                        fieldWithPath("name").description("제품 이름"),
                                        fieldWithPath("level").description("제품 알코올 도수"),
                                        fieldWithPath("info").description("제품 설명"),
                                        fieldWithPath("country").description("제품 제조국"),
                                        fieldWithPath("upperCategory").description("주류 상위 카테고리"),
                                        fieldWithPath("lowerCategory").description("주류 하위 카테고리"),
                                        fieldWithPath("imageId").description("제품 사진 식별 번호")
                                ),
                                responseFields(
                                        fieldWithPath("productId").description("제품 식별 번호")
                                )
                        )
                ).andExpect(status().isCreated());
    }

    @DisplayName("제품을 수정한다")
    @Test
    void 제품을_수정한다() throws Exception {
        Image image = saveImage(ImageFixture.JPEG_IMAGE);
        Product product = saveProduct(ProductFixture.참이슬, image.getId());

        Image newImage = saveImage(ImageFixture.JPEG_IMAGE2);
        String content = objectMapper.writeValueAsString(ProductFixture.일품진로.toProductUpdateRequest(product.getId(), image.getId(), newImage.getId()));

        mockMvc.perform(patch("/api/user/product/update")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(AUTHORIZATION, BEARER_PREFIX + ACCESS_TOKEN))
                .andDo(print())
                .andDo(
                        document("Product/Update",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                requestFields(
                                        fieldWithPath("id").description("수정할 제품 식별 번호"),
                                        fieldWithPath("name").description("제품 이름"),
                                        fieldWithPath("info").description("제품 설명"),
                                        fieldWithPath("level").description("제품 알코올 도수"),
                                        fieldWithPath("country").description("제품 제조국"),
                                        fieldWithPath("upperCategory").description("주류 상위 카테고리"),
                                        fieldWithPath("lowerCategory").description("주류 하위 카테고리"),
                                        fieldWithPath("imageId").description("제품의 기존 사진 식별 번호"),
                                        fieldWithPath("newImageId").description("제품의 새로운 사진 식별 번호")
                                ),
                                responseFields(
                                        fieldWithPath("productId").description("제품 식별 번호")
                                )
                        )
                ).andExpect(status().isCreated());
    }
}