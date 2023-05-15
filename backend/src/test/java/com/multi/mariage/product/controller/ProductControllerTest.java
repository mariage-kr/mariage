package com.multi.mariage.product.controller;

import com.multi.mariage.common.annotation.ControllerTest;
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

class ProductControllerTest extends ControllerTest {
    @DisplayName("제품을 조회한다.")
    @Test
    void 제품을_조회한다() throws Exception {
//TODO: 제품 데이터 삽입
        mockMvc.perform(get("/api/product/find"))
                .andDo(print())
                .andDo(
                        document("Product/FindProducts",
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("product").description("제품 목록"),
//                                        fieldWithPath("product[].id").description("제품 식별자"),
//                                        fieldWithPath("product[].name").description("제품 이름"),
//                                        fieldWithPath("product[].level").description("제품 도수"),
//                                        fieldWithPath("product[].info").description("제품 정보"),
//                                        fieldWithPath("product[].lowerCategory").description("제품 하위카테고리"),
//                                        fieldWithPath("product[].upperCategory").description("제품 상위카테고리"),
//                                        fieldWithPath("product[].country").description("제품 제조국"),
//                                        fieldWithPath("product[].imageId").description("제품 이미지"),
//                                        fieldWithPath("product[].imageUrl").description("제품 이미지 경로"),
                                        fieldWithPath("length").description("제품 개수")
                                )
                        )
                )
                .andExpect(status().isOk());
    }
}