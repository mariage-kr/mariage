package com.multi.mariage.category.controller;

import com.multi.mariage.common.annotation.ControllerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class CategoryControllerTest extends ControllerTest {

    @DisplayName("상위 카테고리 조회 테스트")
    @Test
    void 상위_카테고리_조회() throws Exception {

        mockMvc.perform(get("/api/categories/upper"))
                .andDo(print())
                .andDo(document("Category: FindUpperCategory",
                        preprocessResponse(prettyPrint()),
                                responseFields(
                                        fieldWithPath("category").description("주류 상위 카테고리"),
                                        fieldWithPath("category[].region").description("주류 원산지"),
                                        fieldWithPath("category[].categories[].name").description("주류 상위 카테고리 지칭"),
                                        fieldWithPath("category[].categories[].value").description("주류 상위 카테고리 명칭")
                                )
                )
                )
                .andExpect(status().isOk());
    }
}