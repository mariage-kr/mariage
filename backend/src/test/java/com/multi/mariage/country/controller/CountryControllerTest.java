package com.multi.mariage.country.controller;

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

class CountryControllerTest extends ControllerTest {

    @DisplayName("제조국을 조회한다.")
    @Test
    void 제조국을_조회한다() throws Exception {
        mockMvc.perform(get("/api/country/find"))
                .andDo(print())
                .andDo(document("Country/Find",
                        preprocessResponse(prettyPrint()),
                        responseFields(
                                fieldWithPath("country").description("제조국"),
                                fieldWithPath("length").description("제조국의 개수"),
                                fieldWithPath("country[].id").description("제조국 식별 번호"),
                                fieldWithPath("country[].name").description("제조국 이름"),
                                fieldWithPath("country[].value").description("제조국 값")
                        )))
                .andExpect(status().isOk());
    }
}