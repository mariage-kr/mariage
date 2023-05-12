package com.multi.mariage.category.controller;

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


class CategoryControllerTest extends ControllerTest {

    @DisplayName("주류 상위 카테고리를 조회한다.")
    @Test
    void 주류_상위_카테고리를_조회한다() throws Exception {

        mockMvc.perform(get("/api/categories/upper"))
                .andDo(print())
                .andDo(document("Category/FindUpperCategory",
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("category").description("주류 카테고리"),
                                        fieldWithPath("category[].region").description("주류 원산지"),
                                        fieldWithPath("category[].value").description("주류 원산지 데이터"),
                                        fieldWithPath("category[].categories").description("주류 상위 카테고리"),
                                        fieldWithPath("category[].categories[].name").description("주류 상위 카테고리 이름"),
                                        fieldWithPath("category[].categories[].value").description("주류 상위 카테고리 데이터")
                                )
                        )
                )
                .andExpect(status().isOk());
    }

    @DisplayName("주류 하위 카테고리를 조회한다.")
    @Test
    void 주류_하위_카테고리를_조회한다() throws Exception {

        mockMvc.perform(get("/api/categories/lower"))
                .andDo(print())
                .andDo(document("Category/FindLowerCategory",
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("category").description("주류 카테고리"),
                                        fieldWithPath("category[].region").description("주류 원산지"),
                                        fieldWithPath("category[].regionValue").description("주류 원산지 영어식 명칭"),
                                        fieldWithPath("category[].categories").description("주류 상위 카테고리"),
                                        fieldWithPath("category[].categories[].name").description("주류 상위 카테고리 지칭"),
                                        fieldWithPath("category[].categories[].value").description("주류 상위 카테고리 명칭"),
                                        fieldWithPath("category[].categories[].subCategories").description("주류 하위 카테고리"),
                                        fieldWithPath("category[].categories[].subCategories[].name").description("주류 하위 카테고리 지칭"),
                                        fieldWithPath("category[].categories[].subCategories[].value").description("주류 하위 카테고리 명칭")
                                )
                        )
                )
                .andExpect(status().isOk());
    }

    @DisplayName("음식 카테고리를 조회한다.")
    @Test
    void 음식_카테고리를_조회한다() throws Exception {

        mockMvc.perform(get("/api/categories/food"))
                .andDo(print())
                .andDo(document("Category/FindFoodCategory",
                                preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("category").description("음식 카테고리"),
                                        fieldWithPath("category[].id").description("음식 식별자"),
                                        fieldWithPath("category[].name").description("음식 명칭"),
                                        fieldWithPath("category[].value").description("음식 데이터"),
                                        fieldWithPath("length").description("음식 카테고리 개수")
                                )
                        )
                )
                .andExpect(status().isOk());
    }
}